package com.ytwman.greens.commons.wechat.model;

import java.io.Serializable;

/**
 * 微信 oauth2 登陆请求消息体
 * 如果用户同意授权，页面将跳转至 redirect_uri/?code=CODE&state=STATE。
 * 若用户禁止授权，则重定向后不会带上code参数，仅会带上state参数redirect_uri?state=STATE
 *
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WechatOAuthReq implements Serializable {

    // code作为换取access_token的票据，每次用户授权带上的code将不一样，code只能使用一次，5分钟未被使用自动过期。
    private String code;
    private String state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "WechatOAuthReq{" +
                "code='" + code + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
