/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午11:13
 * Description: 
 */
package com.ytwman.greens.commons.exception;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum BusinessExMessage implements IExMessage {
    Default(10000, "系统异常"),
    GoodsCategoryExistChild(30001, "商品类目存在子节点"),
    ;

    int code;
    String exMessage;

    BusinessExMessage(int code, String exMessage) {
        this.code = code;
        this.exMessage = exMessage;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getExMessage() {
        return exMessage;
    }
}
