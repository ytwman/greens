/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:07
 * Description: 
 */
package com.ytwman.greens.commons.core.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DefaultObjectMapper extends ObjectMapper {

    public DefaultObjectMapper() {
        super();
        // jackson 时区问题
        this.setTimeZone(TimeZone.getTimeZone("GMT+08"));
        // 字段为null时不显示
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}
