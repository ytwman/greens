/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:30
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.google.common.collect.Lists;
import com.ytwman.greens.commons.core.Like;
import com.ytwman.greens.commons.core.exception.ApiException;
import com.ytwman.greens.commons.core.exception.BusinessExMessage;
import com.ytwman.greens.commons.entity.GoodsCategoryEntity;
import com.ytwman.greens.commons.entity.GoodsInfoEntity;
import com.ytwman.greens.commons.entity.mapper.base.GoodsInfoEntityMapper;
import com.ytwman.greens.commons.repo.GoodsInfoMapper;
import com.ytwman.greens.commons.status.Lookup;
import com.ytwman.greens.manager.model.param.GoodsInfoParam;
import com.ytwman.greens.manager.model.param.GoodsInfoSearchParam;
import com.ytwman.greens.manager.model.result.GoodsInfoSearchResult;
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
public class GoodsInfoService {

    @Resource
    GoodsInfoMapper goodsInfoMapper;

    @Resource
    GoodsInfoEntityMapper goodsInfoEntityMapper;

    @Resource
    GoodsCategoryService goodsCategoryService;

    public List<GoodsInfoSearchResult> getAll(GoodsInfoSearchParam searchParam) {
        List<GoodsInfoEntity> entities = goodsInfoMapper.selectByPagination(
                Like.right(searchParam.getKeywords()), searchParam.getCategoryId(), searchParam);
        return Lists.transform(entities, entity -> transform(entity));
    }

    private GoodsInfoSearchResult transform(GoodsInfoEntity entity) {
        GoodsInfoSearchResult result = new GoodsInfoSearchResult();
        BeanUtils.copyProperties(entity, result);

        GoodsCategoryEntity goodsCategoryEntity = goodsCategoryService.get(entity.getCategoryId());
        result.setCategoryName(goodsCategoryEntity.getName());
        return result;
    }

    public GoodsInfoEntity get(Long goodsId) {
        return goodsInfoEntityMapper.selectByPrimaryKey(goodsId);
    }

    public void saveOrUpdate(GoodsInfoParam param) {
        if (param.getId() == null) {
            goodsInfoEntityMapper.insertSelective(param);
        } else {
            goodsInfoEntityMapper.updateByPrimaryKeySelective(param);
        }
    }

    public void delete(Long goodsId) {
        GoodsInfoEntity entity = new GoodsInfoParam();
        entity.setId(goodsId);
        entity.setIsDelete(1);
        goodsInfoEntityMapper.updateByPrimaryKeySelective(entity);
    }

    public void lookup(Long goodsId) {

        // 查询是否存在
        GoodsInfoEntity entity = goodsInfoEntityMapper.selectByPrimaryKey(goodsId);
        if (entity == null) {
            throw new ApiException(BusinessExMessage.GoodsNotFound);
        }

        // 反转上下架状态
        Lookup lookup = Lookup.reverse(entity.getLookup());

        entity = new GoodsInfoParam();
        entity.setId(goodsId);
        entity.setLookup(lookup.getCode());

        goodsInfoEntityMapper.updateByPrimaryKeySelective(entity);
    }
}
