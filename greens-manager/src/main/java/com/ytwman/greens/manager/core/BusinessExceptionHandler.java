/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午11:28
 * Description: 
 */
package com.ytwman.greens.manager.core;

import com.ytwman.greens.commons.exception.ApiException;
import com.ytwman.greens.commons.exception.BusinessExMessage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("code", BusinessExMessage.Default.getCode());
        resultMap.put("exMessage", fieldError.getDefaultMessage());

        return resultMap;
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleMethodArgumentNotValidException(Exception ex) {
        ex.printStackTrace();

        if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            FieldError fieldError = bindException.getBindingResult().getFieldError();

            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("code", BusinessExMessage.Default.getCode());
            resultMap.put("exMessage", fieldError.getDefaultMessage());

            return resultMap;
        }

        return ex;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
