/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午7:11
 * Description: 
 */
package com.ytwman.greens.ups.controller;

import com.google.common.collect.Lists;
import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.model.UpdatePassword;
import com.ytwman.greens.ups.service.UpsOperationLogService;
import com.ytwman.greens.ups.service.UpsUserService;
import com.ytwman.greens.ups.support.Permission;
import com.ytwman.greens.ups.support.UpsUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UPS 账号操作
 *
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
//@Controller
@RequestMapping("/users")
public class UpsUserController {

    @Resource
    UpsUserService upsUserService;

    @Resource
    UpsOperationLogService upsOperationLogService;

    /**
     * 添加用户页面
     */
    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public Object create(ModelAndView modelAndView) {
        return modelAndView;
    }

    /**
     * 添加用户操作
     */
    @Permission
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public Object create(UpsUser upsUser, ModelAndView modelAndView) {
        return modelAndView;
    }

    /**
     * 查询用户信息, 包含: 用户基础信息 \ 权限信息
     */
    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/profiles")
    public Object profiles(ModelAndView modelAndView) {
        return modelAndView;
    }

    /**
     * 修改密码页面
     */
    @Permission
    @RequestMapping(method = RequestMethod.GET, value = "/password/modify")
    public Object passwordModify(ModelAndView modelAndView) {
        modelAndView.setViewName("/users/password_modify");
        return modelAndView;
    }

    /**
     * 修改账号密码, 本人登录修改或者管理员登录修改
     */
    @Permission
    @RequestMapping(method = RequestMethod.POST, value = "/password/modify")
    public Object modifyPassword(UpdatePassword updatePassword, HttpSession httpSession) {
        Long userId = UpsUtils.getUserId(httpSession);
        UpsUser upsUser = upsUserService.getUpsUser(userId);

        upsUserService.passwordModify(upsUser, updatePassword);

        // 修改密码完成后 登出重新登录, 如果是管理员修改则不跳转
        if (UpsUser.Type.Admin.getCode().equals(upsUser.getType())) {
            return passwordModify(new ModelAndView());
        }

        return "redirect:/logout";
    }

    /**
     * 查询用户名
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/finder")
    public Object finder() {
        List<UpsUser> upsUsers = upsUserService.getUpsUsers();
        List<Object> resultSet = Lists.transform(upsUsers, upsUser -> {
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("id", upsUser.getId());
            resultMap.put("text", upsUser.getNickname());
            return resultMap;
        });
        return resultSet;
    }
}
