/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午8:12
 * Description: 
 */
package com.ytwman.greens.ups.controller;

import com.ytwman.greens.ups.support.Permission;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
//@Controller
@RequestMapping("/settings")
public class UpsSettingsController {

    @Permission
    @RequestMapping(method = RequestMethod.GET)
    public Object settings(ModelAndView modelAndView) {
        return modelAndView;
    }

    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Object users(ModelAndView modelAndView) {
        return modelAndView;
    }

    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/roles_permissions")
    public Object rolesPermissions(ModelAndView modelAndView) {
        return modelAndView;
    }

    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/roles")
    public Object roles(ModelAndView modelAndView) {
        return modelAndView;
    }

    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/permissions")
    public Object permissions(ModelAndView modelAndView) {
        return modelAndView;
    }
}
