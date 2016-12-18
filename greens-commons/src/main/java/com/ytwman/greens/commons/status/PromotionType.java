/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午3:11
 * Description: 
 */
package com.ytwman.greens.commons.status;

import java.util.Arrays;

/**
 * 优惠类型
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum PromotionType {
    便宜券(0),
    // 红包
    抵扣券(1),
    // 打折
    折扣券(2),
    立减(2),;

    private int code;

    PromotionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescr() {
        return this.name();
    }

    public static PromotionType get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }
}
