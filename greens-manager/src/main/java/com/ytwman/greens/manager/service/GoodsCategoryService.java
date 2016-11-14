/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午1:28
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.entity.GoodsCategoryEntity;
import com.ytwman.greens.commons.entity.GoodsCategoryEntityExample;
import com.ytwman.greens.commons.entity.mapper.base.GoodsCategoryEntityMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class GoodsCategoryService {

    @Resource
    GoodsCategoryEntityMapper goodsCategoryEntityMapper;

    public List<GoodsCategoryEntity> getAll(String keywords) {
        GoodsCategoryEntityExample example = new GoodsCategoryEntityExample();
        example.setOrderByClause("id desc");

        if (StringUtils.isNotEmpty(keywords)) {
            example.or().andIsDeleteEqualTo(0).andCodeLike(Like.right(keywords));
            example.or().andIsDeleteEqualTo(0).andNameLike(Like.right(keywords));
        }

        return goodsCategoryEntityMapper.selectByExample(example);
    }

    public GoodsCategoryEntity get(Long categoryId) {
        return goodsCategoryEntityMapper.selectByPrimaryKey(categoryId);
    }

    public void save(GoodsCategoryEntity entity) {
        goodsCategoryEntityMapper.insertSelective(entity);
    }

    public void update(GoodsCategoryEntity entity) {
        goodsCategoryEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
