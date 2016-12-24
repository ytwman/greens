package com.ytwman.greens.commons.wechat.model;


import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WechatSignature {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
     */
    private String signature;
    /**
     * 时间戳
     */
    private String timestamp;
    /**
     * 随机数
     */
    private String nonce;
    /**
     * 随机字符串
     */
    private String echostr;

    /**
     * JS 请求 URL,若有 param 也许带上
     */
    private String url;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 用于校验 微信服务器认证请求签名
     *
     * @param token
     * @return
     */
    public boolean checkSignature(String token) {

        List<String> stringList = Lists.newArrayList(token, timestamp, nonce);
        if (CollectionUtils.isEmpty(stringList)) {
            return false;
        }

        Collections.sort(stringList);

        String tmpSignature = Joiner.on("").join(stringList);
        logger.info("微信-排序后连接的结果: {}", tmpSignature);

        String newSignature = DigestUtils.sha1Hex(tmpSignature);
        logger.info("微信-签名的结果: {}", newSignature);

        return newSignature.equals(signature);
    }
}
