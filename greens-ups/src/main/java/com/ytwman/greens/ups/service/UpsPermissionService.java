/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/9/5 下午4:15
 * Description: 
 */
package com.ytwman.greens.ups.service;

import com.ytwman.greens.ups.entity.UpsPermission;
import com.ytwman.greens.ups.entity.UpsPermissionExample;
import com.ytwman.greens.ups.entity.mapper.base.UpsPermissionMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UpsPermissionService {

    @Resource
    UpsPermissionMapper upsPermissionMapper;

    public UpsPermission getUpsPermission(Long permissionId) {
        // 根据主键查询出未删除的功能权限
        UpsPermissionExample example = new UpsPermissionExample();
        example.or().andIsDeleteEqualTo(0).andIdEqualTo(permissionId);
        List<UpsPermission> upsPermissions = upsPermissionMapper.selectByExample(example);

        return CollectionUtils.isNotEmpty(upsPermissions) ? upsPermissions.get(0) : null;
    }

    public List<UpsPermission> getSubUpsPermissions(Long permissionId) {
        UpsPermissionExample example = new UpsPermissionExample();
        example.or().andIsDeleteEqualTo(0).andParentIdEqualTo(permissionId);
        return upsPermissionMapper.selectByExample(example);
    }

    @Cacheable("UpsPermissionService.getUpsPermissions")
    public List<UpsPermission> getUpsPermissions() {
        UpsPermissionExample example = new UpsPermissionExample();
        example.or().andIsDeleteEqualTo(0);
        example.setOrderByClause("sortby asc");
        return upsPermissionMapper.selectByExample(example);
    }

    @CacheEvict(value = "UpsPermissionService.getUpsPermissions", allEntries = true)
    public void create(UpsPermission upsPermission) {
        upsPermissionMapper.insertSelective(upsPermission);
    }

    @CacheEvict(value = "UpsPermissionService.getUpsPermissions", allEntries = true)
    public void delete(Long permissionId) {
        UpsPermission updateUpsPermission = new UpsPermission();
        updateUpsPermission.setId(permissionId);
        updateUpsPermission.setIsDelete(1);
        upsPermissionMapper.updateByPrimaryKeySelective(updateUpsPermission);
    }

    @CacheEvict(value = "UpsPermissionService.getUpsPermissions", allEntries = true)
    public void modify(UpsPermission upsPermission) {
        upsPermissionMapper.updateByPrimaryKeySelective(upsPermission);
    }
}
