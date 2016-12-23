/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午11:13
 * Description: 
 */
package com.ytwman.greens.commons.core.exception;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum BusinessExMessage implements IExMessage {

    // 系统异常，全局
    Default(10000, "系统异常"),
    ParameterError(10001, "请求参数校验异常"),

    // 商品相关
    GoodsCategoryExistChild(30001, "商品类目存在子节点"),
    GoodsCategoryCodeExistChild(30002, "商品类目编码已存在"),
    GoodsNotFound(30003, "商品不存在"),


    // 基础信息
    RegionNotFound(90002, "城市不存在"),
    CommunityNotFound(90002, "社区不存在或和选择的城市不匹配"),
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
