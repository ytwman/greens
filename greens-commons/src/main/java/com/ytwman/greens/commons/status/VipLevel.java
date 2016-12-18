/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/17 上午12:45
 * Description: 
 */
package com.ytwman.greens.commons.status;

import java.util.Arrays;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum VipLevel {
    普通会员(1),
    VIP(2),;

    private int code;

    VipLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String VipLevel() {
        return this.name();
    }

    public static VipLevel get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(普通会员);
    }
}
