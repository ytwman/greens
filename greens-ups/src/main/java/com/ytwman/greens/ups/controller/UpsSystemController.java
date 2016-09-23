/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/9/4 下午11:09
 * Description: 
 */
package com.ytwman.greens.ups.controller;

import com.ytwman.greens.commons.cache.HttpExtend;
import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.service.UpsUserService;
import com.ytwman.greens.ups.support.Permission;
import com.ytwman.greens.ups.support.UpsUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ups 系统操作
 *
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class UpsSystemController {

    @Resource
    UpsUserService upsUserService;

    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public Object index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 登录页面
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public Object login(ModelAndView modelAndView, HttpSession httpSession) {
        if (UpsUtils.getUserId(httpSession) != null) {
            return "redirect:/";
        }
        return modelAndView;
    }

    /**
     * 账号登录操作
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Object login(String username, String password, HttpServletRequest request) {
        UpsUser upsUser = upsUserService.login(username, password);
        if (upsUser != null) {
            // 保存 Session 状态
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute(HttpExtend.Session.UserId, upsUser.getId());
        }

        return upsUser != null;
    }

    /**
     * 退出系统
     */
    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(HttpServletRequest request) {
        // 先清除所有用户的 session
        UpsUtils.cleanSession(request.getSession());
        return "redirect:/login";
    }

    @Permission
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public Object test() {
        return true;
    }
}
