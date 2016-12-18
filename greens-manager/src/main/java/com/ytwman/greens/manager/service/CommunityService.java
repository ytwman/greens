/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/15 上午9:46
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.entity.CommunityEntity;
import com.ytwman.greens.commons.entity.mapper.base.CommunityEntityMapper;
import com.ytwman.greens.commons.repo.CommunityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class CommunityService {

    @Resource
    CommunityMapper communityMapper;

    @Resource
    CommunityEntityMapper communityEntityMapper;

    public List<CommunityEntity> getAll(String keywords) {
        return communityMapper.findAll(Like.right(keywords));
    }

    public CommunityEntity get(Long communityId) {
        return communityMapper.findById(communityId);
    }

    public void save(CommunityEntity entity) {
        communityEntityMapper.insertSelective(entity);
    }

    public void update(CommunityEntity entity) {
        communityEntityMapper.updateByPrimaryKeySelective(entity);
    }

    public void delete(Long communityId) {
        CommunityEntity entity = new CommunityEntity();
        entity.setId(communityId);
        entity.setIsDelete(1);
        communityEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
