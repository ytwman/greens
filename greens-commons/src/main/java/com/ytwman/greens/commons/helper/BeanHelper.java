/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/4 下午10:42
 * Description: 
 */
package com.ytwman.greens.commons.helper;

import org.springframework.beans.BeanUtils;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BeanHelper {

    public static <T> T transform(Class<T> targetClass, Object source) {
        if (source == null) {
            return null;
        }
        try {
            T dest = targetClass.newInstance();
            BeanUtils.copyProperties(dest, source);
            return dest;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
