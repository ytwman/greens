/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午1:28
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.entity.GoodsCategoryEntity;
import com.ytwman.greens.commons.entity.mapper.base.GoodsCategoryEntityMapper;
import com.ytwman.greens.commons.core.exception.ApiException;
import com.ytwman.greens.commons.core.exception.BusinessExMessage;
import com.ytwman.greens.commons.repo.GoodsCategoryMapper;
import com.ytwman.greens.manager.model.param.GoodsCategoryParam;
import org.apache.commons.collections.CollectionUtils;
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
    GoodsCategoryMapper goodsCategoryMapper;

    @Resource
    GoodsCategoryEntityMapper goodsCategoryEntityMapper;

    public List<GoodsCategoryEntity> getAll(String keywords) {
        return goodsCategoryMapper.findAll(Like.all(keywords == null ? null : keywords.toUpperCase()));
    }

    public GoodsCategoryEntity get(Long categoryId) {
        return goodsCategoryMapper.findById(categoryId);
    }

    public void saveOrUpdate(GoodsCategoryParam param) {

        if (param.getId() == null) {
            // 商品编码
            String goodsCategoryCode = String.format("%02d", param.getId());
            param.setCode(goodsCategoryCode);

            goodsCategoryEntityMapper.insertSelective(param);
        } else {
            // 防止更新编码
            param.setCode(null);
            goodsCategoryEntityMapper.updateByPrimaryKeySelective(param);
        }
    }

    public void delete(Long categoryId) {
        // 查询是否有子节点
        List<GoodsCategoryEntity> entities = goodsCategoryMapper.findByParentId(categoryId);
        if (CollectionUtils.isNotEmpty(entities)) {
            throw new ApiException(BusinessExMessage.GoodsCategoryExistChild);
        }

        // 删除节点
        GoodsCategoryEntity entity = new GoodsCategoryEntity();
        entity.setId(categoryId);
        entity.setIsDelete(1);
        goodsCategoryEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
