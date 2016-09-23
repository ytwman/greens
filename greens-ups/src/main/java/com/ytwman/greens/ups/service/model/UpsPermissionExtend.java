/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/29 上午2:00
 * Description: 
 */
package com.ytwman.greens.ups.service.model;

import com.ytwman.greens.ups.entity.UpsPermission;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UpsPermissionExtend extends UpsPermission {
    private Long roleId;

    public UpsPermissionExtend() {
    }

    public UpsPermissionExtend(Long roleId, UpsPermission upsPermission) {
        this.setRoleId(roleId);
        this.setId(upsPermission.getId());
        this.setName(upsPermission.getName());
        this.setParentId(upsPermission.getParentId());
        this.setAction(upsPermission.getAction());
        this.setPath(upsPermission.getPath());
        this.setDescription(upsPermission.getDescription());
        this.setCreatedTime(upsPermission.getCreatedTime());
        this.setUpdatedTime(upsPermission.getUpdatedTime());
        this.setIsDelete(upsPermission.getIsDelete());
    }

    public void setUpsPermission(UpsPermission upsPermission) {
        this.setId(upsPermission.getId());
        this.setName(upsPermission.getName());
        this.setParentId(upsPermission.getParentId());
        this.setAction(upsPermission.getAction());
        this.setPath(upsPermission.getPath());
        this.setDescription(upsPermission.getDescription());
        this.setCreatedTime(upsPermission.getCreatedTime());
        this.setUpdatedTime(upsPermission.getUpdatedTime());
        this.setIsDelete(upsPermission.getIsDelete());
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
