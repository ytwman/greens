/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/9/5 上午1:21
 * Description: 
 */
package com.ytwman.greens.ups.service;

import com.ytwman.greens.ups.entity.UpsPermission;
import com.ytwman.greens.ups.entity.UpsRole;
import com.ytwman.greens.ups.entity.UpsRoleExample;
import com.ytwman.greens.ups.entity.UpsRolePermission;
import com.ytwman.greens.ups.entity.mapper.base.UpsPermissionMapper;
import com.ytwman.greens.ups.entity.mapper.base.UpsRoleMapper;
import com.ytwman.greens.ups.entity.mapper.base.UpsRolePermissionMapper;
import com.ytwman.greens.ups.service.model.UpsPermissionExtend;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UpsRoleService {

    @Resource
    UpsRoleMapper upsRoleMapper;

    @Resource
    UpsPermissionMapper upsPermissionMapper;

    @Resource
    UpsRolePermissionMapper upsRolePermissionMapper;

    @Resource
    UpsPermissionService upsPermissionService;

    /**
     * 返回角色权限对应的增强
     */
    @Cacheable("UpsRoleService.allRoleAndPermission")
    public List<UpsPermissionExtend> allRoleAndPermission() {
        List<UpsPermissionExtend> upsPermissionExtends = new ArrayList<>();

        // 查询出全部角色和权限中间表数据
        List<UpsRolePermission> upsRolePermissions = upsRolePermissionMapper.selectByExample(null);
        for (UpsRolePermission upsRolePermission : upsRolePermissions) {
            UpsPermission upsPermission = upsPermissionService.getUpsPermission(upsRolePermission.getPermissionId());
            if (upsPermission == null) {
                continue;
            }

            Long roleId = upsRolePermission.getRoleId();
            upsPermissionExtends.add(new UpsPermissionExtend(roleId, upsPermission));

            // 如果权限节点有下级也查询出来放进去
            List<UpsPermission> subUpsPermissions = upsPermissionService.getSubUpsPermissions(upsPermission.getId());
            if (CollectionUtils.isNotEmpty(subUpsPermissions)) {
                for (UpsPermission subUpsPermission : subUpsPermissions) {
                    upsPermissionExtends.add(new UpsPermissionExtend(roleId, subUpsPermission));
                }
            }
        }
        return upsPermissionExtends;
    }

    public UpsRole getUpsRole(Long roleId) {
        UpsRole upsRole = upsRoleMapper.selectByPrimaryKey(roleId);
        return upsRole == null ? null : upsRole.getIsDelete().equals(0) ? upsRole : null;
    }

    @Cacheable("UpsRoleService.getUpsRoles")
    public List<UpsRole> getUpsRoles() {
        UpsRoleExample example = new UpsRoleExample();
        example.or().andIsDeleteEqualTo(0);
        return upsRoleMapper.selectByExample(example);
    }

    @CacheEvict(value = "UpsRoleService.getUpsRoles", allEntries = true)
    public void create(UpsRole upsRole) {
        upsRoleMapper.insertSelective(upsRole);
    }

    @CacheEvict(value = "UpsRoleService.getUpsRoles", allEntries = true)
    public void delete(Long roleId) {
        UpsRole updateUpsRole = new UpsRole();
        updateUpsRole.setId(roleId);
        updateUpsRole.setIsDelete(1);
        upsRoleMapper.updateByPrimaryKeySelective(updateUpsRole);
    }

    @CacheEvict(value = "UpsRoleService.getUpsRoles", allEntries = true)
    public void modify(UpsRole upsRole) {
        upsRoleMapper.updateByPrimaryKeySelective(upsRole);
    }

}
