package com.ytwman.greens.commons.wechat;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.ytwman.greens.commons.wechat.model.message.WechatMessage;
import com.ytwman.greens.commons.wechat.model.WechatOAuthResp;
import com.ytwman.greens.commons.wechat.model.WechatUserInfoResp;
import net.spy.memcached.compat.log.Logger;
import net.spy.memcached.compat.log.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * 微信登录\授权\获取用户信息\刷新 token 等基础服务
 * <p>
 * 用户登录相关的接口流程: https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140842&token=&lang=zh_CN
 * 尤其注意：由于授权操作安全等级较高，所以在发起授权请求时，微信会对授权链接做正则强匹配校验，如果链接的参数顺序不对，授权页面将无法正常访问
 * <p>
 * 测试账号: http://mp.weixin.qq.com/debug/cgi-bin/sandboxinfo?action=showinfo&t=sandbox/index
 */
@Service
public class WechatService {

    final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 微信 OAuth2 响应内容类型
     */
    public static final String RESPONSE_TYPE_CODE = "code";

    /**
     * GRANT_TYPE:
     * 1.authorization_code 获取授权码
     * 2.refresh_token      刷新令牌
     * 3.client_credential  客户端授权
     */
    public static final String GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code";
    public static final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
    public static final String GRANT_TYPE_CLIENT_CREDENTIAL = "client_credential";


    /** 应用授权作用域 */
    /**
     * snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid）
     */
    public static final String SCOPE_BASE = "snsapi_base";
    /**
     * snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
     */
    public static final String SCOPE_USERINFO = "snsapi_userinfo";


    // 公众号的唯一标识
    @Value("${wechat.appid}")
    private String appId;

    // 公众号的 appsecret
    @Value("${wechat.appsecret}")
    private String secret;

    // 明文加解密 key
    @Value("${wechat.encodingAESKey}")
    private String encodingAESKey;

    // 授权后重定向的回调链接地址，请使用urlencode对链接进行处理
    @Value("${wechat.oauth2.redirectUrl}")
    private String redirectUri;

    // 返回类型，请填写 code
    private String responseType;

    // 填写第一步获取的 code 参数
    private String code;

    // 填写为authorization_code
    private String grantType;

    // 填写通过access_token获取到的refresh_token参数
    private String refreshToken;

    // 应用授权作用域:
    // snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid）
    // snsapi_userinfo （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
    private String scope;

    // 重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
    private String state;

    // 无论直接打开还是做页面302重定向时候，必须带此参数
    // 若提示“该链接无法访问”，请检查参数是否填写错误，是否拥有scope参数对应的授权作用域权限。
    private String wechatRedirect = "#wechat_redirect";

    public String request(String requestUrl) {
        logger.debug("WeChat request: {}", requestUrl);

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(requestUrl);

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String post(String requestUrl, Object obj) {
        logger.debug("WeChat request: {}", requestUrl);

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(requestUrl);

        try {
            if (obj != null) {
                httpPost.setEntity(new StringEntity(JSON.toJSONString(obj), ContentType.APPLICATION_JSON));
            }

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 第一步：用户同意授权，获取code
     * 授权请求
     *
     * @param scope 请求类型,常量 参见:SCOPE_BASE, SCOPE_USERINFO
     * @param state 请求状态码
     * @return
     */
    public String authorize(String scope, String state) {
        String pattern = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=%s&scope=%s&state=%s%s";

        String redirectUrl = null;
        try {
            redirectUrl = URLEncoder.encode(redirectUri, Charsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return String.format(pattern, appId, redirectUrl, RESPONSE_TYPE_CODE, scope, state, wechatRedirect);
    }

    /**
     * 普通授权, 静默授权, 用户无感知
     *
     * @param state
     * @return
     */
    public String authorizeQuiet(String state) {
        return authorize(SCOPE_BASE, state);
    }

    /**
     * 网页授权, 可以获取到更多的用户信息,适用于第一次授权
     *
     * @param state
     * @return
     */
    public String authorize(String state) {
        return authorize(SCOPE_USERINFO, state);
    }

    /**
     * 第二步：通过code换取网页授权access_token
     * 首先请注意，这里通过code换取的是一个特殊的网页授权 access_token,与基础支持中的access_token（该access_token用于调用其他接口）不同。
     * 公众号可通过下述接口来获取网页授权access_token。
     * 如果网页授权的作用域为snsapi_base，则本步骤中获取到网页授权access_token的同时，也获取到了openid，snsapi_base式的网页授权流程即到此为止。
     * <p>
     * <pre>尤其注意：由于公众号的secret和获取到的access_token安全级别都非常高，必须只保存在服务器，不允许传给客户端。
     * 后续刷新access_token、通过access_token获取用户信息等步骤，也必须从服务器发起。</pre>
     *
     * @param code 填写第一步获取的code参数
     * @return
     */
    @Cacheable("AuthorizeAccessToken")
    public WechatOAuthResp accessToken(String code) {
        String pattern = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=%s";

        String resp = request(String.format(pattern, appId, secret, code, GRANT_TYPE_AUTHORIZATION_CODE));
        if (StringUtils.isNoneEmpty(resp)) {
            return JSON.parseObject(resp, WechatOAuthResp.class);
        }

        return null;
    }

    /**
     * 第三步：刷新access_token（如果需要）
     * 刷新 token
     *
     * @param refreshToken
     * @return
     */
    public WechatOAuthResp refreshToken(String refreshToken) {
        String pattern = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=%s&refresh_token=%s";

        String resp = request(String.format(pattern, appId, GRANT_TYPE_REFRESH_TOKEN, refreshToken));
        if (StringUtils.isNoneEmpty(resp)) {
            return JSON.parseObject(resp, WechatOAuthResp.class);
        }

        return null;
    }


    /**
     * 第四步：拉取用户信息(需scope为 snsapi_userinfo)
     * 拉取用户信息(需scope为 snsapi_userinfo)
     * 如果网页授权作用域为snsapi_userinfo，则此时开发者可以通过access_token和openid拉取用户信息了。
     *
     * @param weChatOAuthResp 授权相应内容
     * @return
     */
    public WechatUserInfoResp getUserInfo(WechatOAuthResp weChatOAuthResp) {
        String pattern = "https://api.weixin.qq.com/sns/userinfo?openid=%s&access_token=%s&lang=zh_CN";

        // 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
        String resp = request(String.format(pattern, weChatOAuthResp.getOpenid(), weChatOAuthResp.getAccessToken()));
        if (StringUtils.isNoneEmpty(resp)) {
            return JSON.parseObject(resp, WechatUserInfoResp.class);
        }

        return null;
    }

    /**
     * access_token 是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。
     * 开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。
     * access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
     * <p>
     * 详细文档:http://mp.weixin.qq.com/wiki/11/0e4b294685f817b95cbed85ba5e82b8f.html
     */
    @Cacheable("WechatAccessToken")
    public WechatOAuthResp getGlobalToken() {
        String pattern = "https://api.weixin.qq.com/cgi-bin/token?grant_type=%s&appid=%s&secret=%s";

        String resp = request(String.format(pattern, GRANT_TYPE_CLIENT_CREDENTIAL, appId, secret));
        if (StringUtils.isNoneEmpty(resp)) {
            return JSON.parseObject(resp, WechatOAuthResp.class);
        }

        return null;
    }

    /**
     * 发送公告
     * @param weChatMessage
     */
    public void sendNotice(WechatMessage weChatMessage) {
        String pattern = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";
        WechatOAuthResp weChatOAuthResp = getGlobalToken();
        String resp = post(String.format(pattern, weChatOAuthResp.getAccessToken()), weChatMessage);
        logger.info(resp);
    }

}
