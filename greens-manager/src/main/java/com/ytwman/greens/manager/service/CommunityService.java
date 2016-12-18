/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/15 上午9:46
 * Description: 
 */
package com.ytwman.greens.manager.service;

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

    public List<CommunityEntity> getByRegion(Long regionId, String keywords) {
        return null;
    }
}
