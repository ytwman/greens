/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午6:13
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.entity.RegionEntity;
import com.ytwman.greens.commons.repo.RegionMapper;
import com.ytwman.greens.commons.status.RegionLevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class RegionService {

    @Resource
    RegionMapper regionMapper;

    // 查询出所有的省份
    public List<RegionEntity> provinces() {
        return regionMapper.findByLevel(RegionLevel.省份.getCode());
    }

    public List<RegionEntity> getSubset(Long id) {
        return regionMapper.findByParentId(id);
    }

    public RegionEntity get(Long id) {
        return regionMapper.findById(id);
    }

    public RegionEntity getParent(Long id) {
        return  regionMapper.findParentById(id);
    }
}
