/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/16 上午12:19
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.google.common.collect.Lists;
import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.core.exception.ApiException;
import com.ytwman.greens.commons.core.exception.BusinessExMessage;
import com.ytwman.greens.commons.entity.CommunityEntity;
import com.ytwman.greens.commons.entity.RegionEntity;
import com.ytwman.greens.commons.entity.UserInfoEntity;
import com.ytwman.greens.commons.entity.mapper.base.UserInfoEntityMapper;
import com.ytwman.greens.commons.helper.BeanHelper;
import com.ytwman.greens.commons.repo.UserInfoMapper;
import com.ytwman.greens.manager.model.param.UserInfoParam;
import com.ytwman.greens.manager.model.result.UserInfoResult;
import org.springframework.beans.BeanUtils;
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
    RegionService regionService;

    @Resource
    CommunityService communityService;

    @Resource
    UserInfoMapper userInfoMapper;

    @Resource
    UserInfoEntityMapper userInfoEntityMapper;

    public List<UserInfoResult> getAll(String keywords, Long communityId) {
        List<UserInfoEntity> entities = userInfoMapper.findAll(Like.rightUpperCase(keywords), communityId);
        return Lists.transform(entities, entity -> transform(entity));
    }

    private UserInfoResult transform(UserInfoEntity entity) {
        UserInfoResult result = new UserInfoResult();
        BeanUtils.copyProperties(entity, result);

        RegionEntity province = regionService.get(entity.getProvince());
        RegionEntity city = regionService.get(entity.getCity());
        RegionEntity district = regionService.get(entity.getDistrict());
        CommunityEntity community = communityService.get(entity.getCommunity());
        result.setProvinceName(province.getName());
        result.setCityName(city.getName());
        result.setDistrictName(district.getName());
        result.setCommunityName(community.getName());
        return result;
    }

    public UserInfoEntity get(Long userId) {
        return userInfoMapper.findById(userId);
    }

    public void saveOrUpdate(UserInfoParam param) {
        // 验证城市是否存在
        RegionEntity regionEntity = regionService.getParent(param.getRegionId());
        if (regionEntity == null) {
            throw new ApiException(BusinessExMessage.RegionNotFound);
        }

        // 验证社区是否存在
        CommunityEntity communityEntity = communityService.get(param.getCommunity());
        if (communityEntity == null || !communityEntity.getRegionId().equals(param.getRegionId())) {
            throw new ApiException(BusinessExMessage.CommunityNotFound);
        }

        // 城市和省份信息
        param.setProvince(regionEntity.getParentId());
        param.setCity(regionEntity.getId());
        param.setDistrict(param.getRegionId());

        if (param.getId() == null) {
            userInfoEntityMapper.insertSelective(param);
        } else {
            userInfoEntityMapper.updateByPrimaryKeySelective(param);
        }
    }

    public void delete(Long userId) {
        // 删除节点
        UserInfoEntity entity = new UserInfoEntity();
        entity.setId(userId);
        entity.setIsDelete(1);
        userInfoEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
