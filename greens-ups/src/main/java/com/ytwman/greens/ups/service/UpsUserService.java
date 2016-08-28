/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午8:02
 * Description: 
 */
package com.ytwman.greens.ups.service;

import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.entity.UpsUserRole;
import com.ytwman.greens.ups.entity.UpsUserRoleExample;
import com.ytwman.greens.ups.entity.mapper.base.UpsUserMapper;
import com.ytwman.greens.ups.entity.mapper.base.UpsUserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    /**
     * 修改登录密码
     *
     * @param userId      用户主键
     * @param passoword   旧密码
     * @param newPassword 新密码
     */
    public void passwordUpdate(Long userId, String passoword, String newPassword) {
        UpsUser upsUser = upsUserMapper.selectByPrimaryKey(userId);
        if (upsUser == null) {
            throw new RuntimeException("用户不存在");
        }

        // 用户角色
        UpsUserRoleExample upsUserRoleExample = new UpsUserRoleExample();
        upsUserRoleExample.or().andUserIdEqualTo(userId);
        List<UpsUserRole> upsUserRoles = upsUserRoleMapper.selectByExample(upsUserRoleExample);
    }

    /**
     * 是否管理员
     *
     * @param upsUser
     * @return
     */
    public boolean isManager(UpsUser upsUser) {
        return true;
    }
}
