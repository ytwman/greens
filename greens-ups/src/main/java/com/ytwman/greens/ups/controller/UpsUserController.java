/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午7:11
 * Description: 
 */
package com.ytwman.greens.ups.controller;

import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.model.UpdatePassword;
import com.ytwman.greens.ups.service.UpsOperationLogService;
import com.ytwman.greens.ups.service.UpsUserService;
import com.ytwman.greens.ups.support.HttpExtend;
import com.ytwman.greens.ups.support.Permission;
import com.ytwman.greens.ups.support.UpsUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    UpsUserService upsUserService;

    @Resource
    UpsOperationLogService upsOperationLogService;

    /**
     * 登录页面
     */
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public Object login() {
        return new ModelMap();
    }

    /**
     * 账号登录
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Object login(String username, String password, HttpServletRequest request) {
        UpsUser upsUser = upsUserService.login(username, password);
        if (upsUser != null) {
            // 保存 Session 状态
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute(HttpExtend.Session.UserId, upsUser.getId());
            return "redirect:/";
        }
        return "redirect:/login";
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

    /**
     * 修改账号密码, 本人登录修改或者管理员登录修改
     */
    @RequestMapping("/password/update")
    public String updatePassword(UpdatePassword updatePassword, HttpSession httpSession) {
        Long userId = UpsUtils.getUserId(httpSession);
        upsUserService.passwordUpdate(userId, updatePassword);

        return null;
    }

    /**
     * 添加用户,仅限管理员操作
     */
    @Permission
    @RequestMapping("/account/create")
    public String accountCreate(UpsUser upsUser) {
        return null;
    }
}
