package com.ytwman.greens.commons.wechat.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 微信 OAuth2 返回的结构体
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WechatOAuthResp extends WechatErrorResp implements Serializable {
    /**
     * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    @JsonProperty("access_token")
    @JSONField(name = "access_token")
    private String accessToken;

    private String ticket;

    /**
     * access_token 接口调用凭证超时时间，单位（秒）
     */
    @JsonProperty("expires_in")
    @JSONField(name = "expires_in")
    private String expiresIn;

    /**
     * 用户刷新 access_token
     */
    @JsonProperty("refresh_token")
    @JSONField(name = "refresh_token")
    private String refreshToken;

    /**
     * 用户的唯一标识
     */
    @JsonProperty("openid")
    @JSONField(name = "openid")
    private String openid;

    /**
     * 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     */
    @JsonProperty("lang")
    @JSONField(name = "lang")
    private String lang;

    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    @JsonProperty("scope")
    @JSONField(name = "scope")
    private String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "WeChatOAuthResp{" +
                "accessToken='" + accessToken + '\'' +
                ", ticket='" + ticket + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", openid='" + openid + '\'' +
                ", lang='" + lang + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}