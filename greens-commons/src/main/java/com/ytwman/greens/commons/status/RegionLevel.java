/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/17 上午12:31
 * Description: 
 */
package com.ytwman.greens.commons.status;

import java.util.Arrays;

/**
 * 地区等级
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum RegionLevel {
    国家(1),
    省份(2),
    城市(3),
    县市区(4),
    乡镇街道(5),
    村(6),;

    private int code;

    RegionLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescr() {
        return this.name();
    }

    public static RegionLevel get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }
}
