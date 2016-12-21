package com.ytwman.greens.ups.status;

import java.util.Arrays;

/**
 * Created by ytwman on 16/12/21.
 */
public enum Menu {
    按钮(1),
    菜单(2),;

    private int code;

    Menu(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescr() {
        return this.name();
    }

    public static Menu get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }
}
