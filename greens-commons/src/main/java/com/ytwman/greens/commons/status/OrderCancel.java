/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/17 上午12:38
 * Description: 
 */
package com.ytwman.greens.commons.status;

import java.util.Arrays;

/**
 * 订单取消类型
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum OrderCancel {
    超时未支付(1),
    用户关闭(2),;

    private int code;

    OrderCancel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescr() {
        return this.name();
    }

    public static OrderCancel get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }
}
