package com.ytwman.greens.commons.wechat.model.message;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WechatMessageData {

    /**
     * 数据 key
     */
    @JsonIgnore
    private String key;
    /**
     * 值
     */
    private String value;
    /**
     * 值颜色
     */
    private String color;

    public WechatMessageData() {
    }

    public WechatMessageData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public WechatMessageData(String key, String value, String color) {
        this.key = key;
        this.value = value;
        this.color = color;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}