/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/8/28 下午8:02
 * Description:
 */
package com.ytwman.greens.ups.service;

import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.entity.UpsUserExample;
import com.ytwman.greens.ups.entity.UpsUserRole;
import com.ytwman.greens.ups.entity.UpsUserRoleExample;
import com.ytwman.greens.ups.entity.mapper.base.UpsUserMapper;
import com.ytwman.greens.ups.entity.mapper.base.UpsUserRoleMapper;
import com.ytwman.greens.ups.model.UpdatePassword;
import com.ytwman.greens.ups.support.UpsUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
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
public class UpsUserService {

    @Resource
    UpsUserMapper upsUserMapper;

    @Resource
    UpsUserRoleMapper upsUserRoleMapper;

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
    public void passwordModify(UpsUser upsUser, UpdatePassword updatePassword) {
        // 若修改密码的用户主键和当前登录的用户主键相同直接修改密码
        // 若不相同判断当前登录用户是否系统管理员
        // 若自己登录的验证旧密码

        if (!UpsUtils.isAdmin(upsUser)) {
            if (upsUser.getId().equals(updatePassword.getUserId())) {
                UpsUser updateUpsUser = getUpsUser(updatePassword.getUserId());

                String passwd = DigestUtils.sha1Hex(updatePassword.getPassword());
                if (!updateUpsUser.getPassword().equals(passwd)) {
                    throw new RuntimeException("老密码错误");
                }
            } else {
                throw new RuntimeException("当前登录用户无权执行此操作");
            }
        }

        // 修改账号密码
        UpsUser updateUpsUser = new UpsUser();
        updateUpsUser.setId(updatePassword.getUserId());
        updateUpsUser.setPassword(DigestUtils.sha1Hex(updatePassword.getNewPassword()));
        upsUserMapper.updateByPrimaryKeySelective(updateUpsUser);
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

    public List<UpsUser> getUpsUsers() {
        UpsUserExample example = new UpsUserExample();
        example.or().andIsDeleteEqualTo(0);
        return upsUserMapper.selectByExample(example);
    }

}
