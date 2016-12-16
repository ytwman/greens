/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/17 上午12:42
 * Description: 
 */
package com.ytwman.greens.commons.status;

import java.util.Arrays;

/**
 * 审核状态
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum AuditStatus {
    待审核(1),
    审核成功(2),
    审核失败(3),;

    private int code;

    AuditStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescr() {
        return this.name();
    }

    public static AuditStatus get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }
}
