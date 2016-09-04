/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午8:02
 * Description:
 */
package com.ytwman.greens.ups.service;

import com.ytwman.greens.ups.entity.*;
import com.ytwman.greens.ups.entity.mapper.base.UpsPermissionMapper;
import com.ytwman.greens.ups.entity.mapper.base.UpsRolePermissionMapper;
import com.ytwman.greens.ups.entity.mapper.base.UpsUserMapper;
import com.ytwman.greens.ups.entity.mapper.base.UpsUserRoleMapper;
import com.ytwman.greens.ups.model.UpdatePassword;
import com.ytwman.greens.ups.service.model.UpsPermissionExtend;
import com.ytwman.greens.ups.support.UpsUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
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
public class UpsUserService {

    @Resource
    UpsUserMapper upsUserMapper;

    @Resource
    UpsUserRoleMapper upsUserRoleMapper;

    @Resource
    UpsPermissionMapper upsPermissionMapper;

    @Resource
    UpsRolePermissionMapper upsRolePermissionMapper;

    public UpsUser login(String username, String password) {
        UpsUserExample example = new UpsUserExample();
        example.or().andUsernameEqualTo(username)
                .andPasswordEqualTo(DigestUtils.sha1Hex(password));

        List<UpsUser> upsUsers = upsUserMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(upsUsers) ? upsUsers.get(0) : null;
    }

    /**
     * 修改登录密码
     */
    public void passwordUpdate(Long userId, UpdatePassword updatePassword) {
        // 若修改密码的用户主键和当前登录的用户主键相同直接修改密码
        // 若不相同判断当前登录用户是否系统管理员
        // 若自己登录的验证旧密码
        if (userId.equals(updatePassword.getUserId())) {
            UpsUser upsUser = getUpsUser(updatePassword.getUserId());

            String passwd = DigestUtils.sha1Hex(updatePassword.getPassword());
            if (!upsUser.getPassword().equals(passwd)) {
                throw new RuntimeException("老密码错误");
            }
        } else {
            UpsUser upsUser = getUpsUser(userId);
            if (upsUser == null) {
                throw new RuntimeException("用户不存在");
            }

            if (!UpsUtils.isAdmin(upsUser)) {
                throw new RuntimeException("当前登录用户无权执行此操作");
            }
        }

        // 修改账号密码
        UpsUser updateUpsUser = new UpsUser();
        updateUpsUser.setId(updatePassword.getUserId());
        updateUpsUser.setPassword(DigestUtils.sha1Hex(updatePassword.getNewPassword()));
        upsUserMapper.updateByPrimaryKeySelective(updateUpsUser);
    }

    public UpsPermission getLoginPermission() {
        UpsPermission upsPermission = new UpsPermission();
        upsPermission.setId(1l);
        upsPermission.setName("登录");
        return upsPermission;
    }

    @Cacheable("UpsUserService.getUpsUser")
    public UpsUser getUpsUser(Long userId) {
        return upsUserMapper.selectByPrimaryKey(userId);
    }

    @Cacheable("UpsUserService.getUpsUserRole")
    public List<UpsUserRole> getUpsUserRole(Long userId) {
        UpsUserRoleExample example = new UpsUserRoleExample();
        example.or().andUserIdEqualTo(userId);
        return upsUserRoleMapper.selectByExample(example);
    }

    @Cacheable("UpsUserService.allRoleAndPermission")
    public List<UpsPermissionExtend> allRoleAndPermission() {
        List<UpsPermissionExtend> upsPermissionExtends = new ArrayList<>();

        // 查询出全部角色和权限中间表数据
        List<UpsRolePermission> upsRolePermissions = upsRolePermissionMapper.selectByExample(null);
        for (UpsRolePermission upsRolePermission : upsRolePermissions) {
            UpsPermission upsPermission = getUpsPermission(upsRolePermission.getPermissionId());
            if (upsPermission == null) {
                continue;
            }

            Long roleId = upsRolePermission.getRoleId();
            upsPermissionExtends.add(new UpsPermissionExtend(roleId, upsPermission));

            // 如果权限节点有下级也查询出来放进去
            List<UpsPermission> subUpsPermissions = getSubUpsPermissions(upsPermission.getId());
            if (CollectionUtils.isNotEmpty(subUpsPermissions)) {
                for (UpsPermission subUpsPermission : subUpsPermissions) {
                    upsPermissionExtends.add(new UpsPermissionExtend(roleId, subUpsPermission));
                }
            }
        }
        return upsPermissionExtends;
    }

    @Cacheable("UpsUserService.getUpsPermission")
    public UpsPermission getUpsPermission(Long permissionId) {
        // 根据主键查询出未删除的功能权限
        UpsPermissionExample example = new UpsPermissionExample();
        example.or().andIdEqualTo(permissionId).andIsDeleteEqualTo(0);
        List<UpsPermission> upsPermissions = upsPermissionMapper.selectByExample(example);

        return CollectionUtils.isNotEmpty(upsPermissions) ? upsPermissions.get(0) : null;
    }

    @Cacheable("UpsUserService.getSubUpsPermissions")
    public List<UpsPermission> getSubUpsPermissions(Long permissionId) {
        UpsPermissionExample example = new UpsPermissionExample();
        example.or().andParentIdEqualTo(permissionId).andIsDeleteEqualTo(0);
        return upsPermissionMapper.selectByExample(example);
    }
}
