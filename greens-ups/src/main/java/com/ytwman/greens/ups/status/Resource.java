package com.ytwman.greens.ups.status;

import java.util.Arrays;

/**
 * Created by ytwman on 16/12/21.
 */
public enum Resource {
    系统(1),
    模块(2),
    功能(3),
    操作(4),;

    private int code;

    Resource(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescr() {
        return this.name();
    }

    public static Resource get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }
}
