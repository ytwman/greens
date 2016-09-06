/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/9/5 下午4:12
 * Description: 
 */
package com.ytwman.greens.ups.controller;

import com.ytwman.greens.ups.entity.UpsPermission;
import com.ytwman.greens.ups.service.UpsPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/permissions")
public class UpsPermissionController {

    @Resource
    UpsPermissionService upsPermissionService;

    @RequestMapping(method = RequestMethod.GET)
    public Object list() {
        return upsPermissionService.getUpsPermissions();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public void create(UpsPermission upsPermission) {
        upsPermissionService.create(upsPermission);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/modify")
    public void modify(UpsPermission upsPermission) {

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{permissionId}")
    public void delete(@PathVariable("permissionId") Long permissionId) {
        upsPermissionService.delete(permissionId);
    }
}
