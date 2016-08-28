/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午7:11
 * Description: 
 */
package com.ytwman.greens.ups.controller;

import com.ytwman.greens.ups.UpsUtils;
import com.ytwman.greens.ups.annotation.Permission;
import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.service.UpsUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * UPS 账号操作
 *
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class UpsUserController {

    @Resource
    UpsUserService upsService;

    @RequestMapping("/login")
    public void login() {

    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        // 先清除所有用户的 session
        UpsUtils.cleanSession(request.getSession());
        return "redirect:/login";
    }

    /**
     * 重置密码,仅限管理员和当前用户
     */
    @RequestMapping("/password/reset")
    public String reset() {
        return null;
    }

    /**
     * 修改账号密码, 本人登录修改或者管理员登录修改
     */
    @RequestMapping("/password/update")
    public String passwordUpdate(HttpServletRequest request) {
        Long userId = UpsUtils.getUserId(request.getSession());
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");

        upsService.passwordUpdate(userId, password, newPassword);

        return null;
    }

    /**
     * 添加用户,仅限管理员操作
     *
     * @param upsUser
     * @return
     */
    @Permission
    @RequestMapping("/account/create")
    public String accountCreate(UpsUser upsUser) {
        return null;
    }
}
