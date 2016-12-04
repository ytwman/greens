/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午11:28
 * Description: 
 */
package com.ytwman.greens.manager.core;

import com.ytwman.greens.commons.exception.ApiException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerMethodExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@ControllerAdvice
public class BusinessExceptionHandler extends AbstractHandlerMethodExceptionResolver implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request, HttpServletResponse response,
                                                           HandlerMethod handlerMethod, Exception ex) {
        return null;
    }

    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public Object handleBusinessException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        if (ex instanceof ApiException) {
            ApiException apiException = (ApiException) ex;
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("code", apiException.getCode());
            resultMap.put("exMessage", apiException.getExMessage());
            return resultMap;
        }
        return ex;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
