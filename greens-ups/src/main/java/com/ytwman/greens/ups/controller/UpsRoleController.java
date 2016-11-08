/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/9/6 下午4:16
 * Description: 
 */
package com.ytwman.greens.ups.controller;

import com.ytwman.greens.ups.entity.UpsRole;
import com.ytwman.greens.ups.service.UpsRoleService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
//@RestController
@RequestMapping("/roles")
public class UpsRoleController {

    @Resource
    UpsRoleService upsRoleService;

    @RequestMapping(method = RequestMethod.GET)
    public Object list() {
        return upsRoleService.getUpsRoles();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{roleId}")
    public Object show(@PathVariable("roleId") Long roleId) {
        return upsRoleService.getUpsRole(roleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void create(@Valid UpsRole upsRole) {
        upsRoleService.create(upsRole);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{roleId}")
    public void delete(@PathVariable("roleId") Long roleId) {
        upsRoleService.delete(roleId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/modify")
    public void modify(@Valid UpsRole upsRole) {
        upsRoleService.modify(upsRole);
    }
}
