package com.ytwman.greens.commons.wechat.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 错误情况下返回
 * 参照编码表: http://mp.weixin.qq.com/wiki/10/6380dc743053a91c544ffd2b7c959166.html
 */
public class WechatErrorResp implements Serializable {

    /**
     * 错误编码
     */
    @JsonProperty("errcode")
    @JSONField(name = "errcode")
    private Integer errCode;
    /**
     * 错误消息
     */
    @JsonProperty("errmsg")
    @JSONField(name = "errmsg")
    private String message;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WeChatErrorResp{" +
                "errCode=" + errCode +
                ", message='" + message + '\'' +
                '}';
    }
}
