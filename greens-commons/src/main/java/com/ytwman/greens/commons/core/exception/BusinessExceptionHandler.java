/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午11:28
 * Description: 
 */
package com.ytwman.greens.commons.core.exception;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ControllerAdvice
public class BusinessExceptionHandler implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public Object handleBusinessException(ApiException ex) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", ex.getCode());
        resultMap.put("exMessage", ex.getExMessage());

        return resultMap;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleMethodArgumentNotValidException(Exception ex) {
        ex.printStackTrace();

        String exMessage = null;

        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            exMessage = bindException.getBindingResult().getFieldError().getDefaultMessage();
        } else if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) ex;
            exMessage = validException.getBindingResult().getFieldError().getDefaultMessage();
        } else {
            exMessage = ex.getMessage();
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", BusinessExMessage.Default.getCode());
        resultMap.put("exMessage", exMessage);

        return resultMap;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
