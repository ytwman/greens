/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午11:09
 * Description: 
 */
package com.ytwman.greens.commons.core.exception;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ApiException extends RuntimeException {

    int code;
    String exMessage;

    public ApiException(String exMessage) {
        this.code = BusinessExMessage.Default.getCode();
        this.exMessage = exMessage;
    }

    public ApiException(int code, String exMessage) {
        this.code = code;
        this.exMessage = exMessage;
    }

    public ApiException(BusinessExMessage businessExMessage) {
        this.code = businessExMessage.getCode();
        this.exMessage = businessExMessage.getExMessage();
    }

    public int getCode() {
        return code;
    }

    public String getExMessage() {
        return exMessage;
    }
}
