package com.ytwman.greens.commons.wechat.model.message;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WechatMessage implements Serializable {

    /**
     * 消息模板主键
     */
    @JsonProperty("template_id")
    @JSONField(name = "template_id")
    private String templateId;
    /**
     * 用户 OPEN_ID
     */
    private String touser;
    /**
     * 点击打开 URL
     */
    private String url;
    /**
     * 顶部色块颜色
     */
    private String topcolor;
    /**
     * 模板填充数据
     */
    private Map<String, WechatMessageData> data = new HashMap<>();

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public void setData(WechatMessageData data) {
        this.data.put(data.getKey(), data);
    }

    public String getTemplateId() {
        return templateId;
    }

    public String getTouser() {
        return touser;
    }

    public String getUrl() {
        return url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public Map<String, WechatMessageData> getData() {
        return data;
    }

    public static class Builder {
        private WechatMessage weChatMessage;

        public Builder() {
            weChatMessage = new WechatMessage();
        }

        public Builder setTemplateId(String templateId) {
            weChatMessage.setTemplateId(templateId);
            return this;
        }

        public Builder setTouser(String touser) {
            weChatMessage.setTouser(touser);
            return this;
        }

        public Builder setUrl(String url) {
            weChatMessage.setUrl(url);
            return this;
        }

        public Builder setTopcolor(String topcolor) {
            weChatMessage.setTopcolor(topcolor);
            return this;
        }

        public Builder put(String key, String data) {
            weChatMessage.setData(new WechatMessageData(key, data));
            return this;
        }

        public Builder put(WechatMessageData data) {
            weChatMessage.setData(data);
            return this;
        }

        public WechatMessage build() {
            return weChatMessage;
        }
    }
}
