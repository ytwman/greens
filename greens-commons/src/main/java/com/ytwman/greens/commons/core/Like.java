/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午8:55
 * Description: 
 */
package com.ytwman.greens.commons.core;

import org.apache.commons.lang3.StringUtils;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Like {

    public static String left(String key) {
        return StringUtils.isNotEmpty(key) ? "%" + key : null;
    }

    public static String right(String key) {
        return StringUtils.isNotEmpty(key) ? key + "%" : null;
    }

    public static String all(String key) {
        return StringUtils.isNotEmpty(key) ? "%" + key + "%" : null;
    }
}
