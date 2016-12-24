package com.ytwman.greens.commons.wechat;

import com.alibaba.fastjson.JSON;
import com.ytwman.greens.commons.helper.KeyGenerator;
import com.ytwman.greens.commons.wechat.model.WechatOAuthResp;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 获取 JS TOKEN 和 JS SIGN 服务
 * 原本卸载 WeChatBaseService 中, 但是调用 getGlobalToken 方法, 类内部调用内部方法无法 AOP 所以Cache 无效, 所以移出来了
 * 参考文档: http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
 * 校验: http://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=jsapisign
 *
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class WechatJsService {
    final Logger logger = LoggerFactory.getLogger(getClass());

    // 公众号的唯一标识
    @Value("${wechat.appid}")
    private String appId;

    @Resource
    WechatService weChatBaseService;

    /**
     * 获取 JS Token
     *
     * 详细文档: http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
     */
    @Cacheable(value = "WeChatJSToken")
    public WechatOAuthResp getJsToken() {
        String pattern = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

        // 先去获取对应的 全局访问 AccessToken
        WechatOAuthResp wechatOAuthResp = weChatBaseService.getGlobalToken();

        String resp = weChatBaseService.request(String.format(pattern, wechatOAuthResp.getAccessToken()));
        if (StringUtils.isNoneEmpty(resp)) {
            return JSON.parseObject(resp, WechatOAuthResp.class);
        }

        return null;
    }

    /**
     * 根据 jsapi_ticket 获取 签名
     *
     * @param url
     * @return
     */
    @Cacheable("WeChatJSSign")
    public Map<String, String> signature(String url, String jsapiTicket) {
        Map<String, String> ret = new HashMap<>();
        String nonce_str = KeyGenerator.uuid();
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);
        String signature = null;

        //注意这里参数名必须全部小写，且必须有序
        String pattern = "jsapi_ticket=%s&noncestr=%s&timestamp=%s&url=%s";
        String sortedParameter = String.format(pattern, jsapiTicket, nonce_str, timestamp, url);

        logger.trace("微信签名参数:{}", sortedParameter);

        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(sortedParameter.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
            logger.debug("微信生成的签名 signature:{}", signature);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("微信生成签名失败:", e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error("微信生成签名失败:", e);
        }

        ret.put("url", url);
        ret.put("jsapi_ticket", jsapiTicket);
        ret.put("nonceStr", nonce_str);
        ret.put("timestamp", timestamp);
        ret.put("signature", signature);
        ret.put("appid", appId);

        logger.trace(ret.toString());

        return ret;
    }

    private String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}