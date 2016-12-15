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
import com.ytwman.greens.commons.exception.ApiException;
import com.ytwman.greens.commons.exception.BusinessExMessage;
import com.ytwman.greens.commons.repo.GoodsCategoryMapper;
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

    public void saveOrUpdate(GoodsCategoryEntity entity) {
        // 编码转换大写
        entity.setCode(entity.getCode().toUpperCase());
        // 验证商品类目编码是否存在
        GoodsCategoryEntity goodsCategoryEntity = goodsCategoryMapper.findByCode(entity.getCode(), true);

        if (entity.getId() == null) {
            if (goodsCategoryEntity != null) {
                throw new ApiException(BusinessExMessage.GoodsCategoryCodeExistChild);
            }

            goodsCategoryEntityMapper.insertSelective(entity);
        } else {
            // 如果ID 不同但编码相同,提示编码已经存在
            if (goodsCategoryEntity != null && !goodsCategoryEntity.getId().equals(entity.getId())) {
                throw new ApiException(BusinessExMessage.GoodsCategoryCodeExistChild);
            }

            goodsCategoryEntityMapper.updateByPrimaryKeySelective(entity);
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
