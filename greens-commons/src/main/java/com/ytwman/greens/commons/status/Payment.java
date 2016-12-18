/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/17 上午12:50
 * Description: 
 */
package com.ytwman.greens.commons.status;

import com.ytwman.greens.commons.core.exception.ValueAbsentException;

import java.util.Arrays;

/**
 * 支付方式
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum Payment {
    现金(1),
    余额(2),// 优惠属于余额
    支付宝(3),
    微信(4),
    银行卡(5),;

    private int code;

    Payment(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String VipLevel() {
        return this.name();
    }

    public static Payment get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }

    public static Payment legal(int code) throws ValueAbsentException {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElseThrow(ValueAbsentException::new);
    }
}
