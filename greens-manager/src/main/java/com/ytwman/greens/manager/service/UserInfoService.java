/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/16 上午12:19
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.entity.UserInfoEntity;
import com.ytwman.greens.commons.entity.mapper.base.UserInfoEntityMapper;
import com.ytwman.greens.commons.repo.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class UserInfoService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Resource
    UserInfoEntityMapper userInfoEntityMapper;

    public List<UserInfoEntity> getAll(String keywords, Long communityId) {
        return userInfoMapper.findAll(Like.right(keywords == null ? null : keywords.toUpperCase()), communityId);
    }

    public UserInfoEntity get(Long id) {
        return userInfoMapper.findById(id);
    }

    public void saveOrUpdate(UserInfoEntity entity) {
        if (entity.getId() == null) {
            userInfoEntityMapper.insertSelective(entity);
        } else {
            userInfoEntityMapper.updateByPrimaryKeySelective(entity);
        }
    }

    public void delete(Long id) {
        // 删除节点
        UserInfoEntity entity = new UserInfoEntity();
        entity.setId(id);
        entity.setIsDelete(1);
        userInfoEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
