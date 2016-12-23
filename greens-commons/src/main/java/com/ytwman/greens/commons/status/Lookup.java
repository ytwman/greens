package com.ytwman.greens.commons.status;

import java.util.Arrays;

/**
 * 商品上下架状态
 * Created by ytwman on 16/12/23.
 */
public enum Lookup {
    未上架(0),
    上架(1),;

    private int code;

    Lookup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescr() {
        return this.name();
    }

    public static Lookup get(int code) {
        return Arrays.asList(values()).stream().filter(e -> e.getCode() == code).findFirst().orElse(null);
    }

    public Lookup reverse() {
        return this == Lookup.上架 ? Lookup.未上架 : Lookup.上架;
    }

    public static Lookup reverse(int code) {
        return get(code).reverse();
    }
}
