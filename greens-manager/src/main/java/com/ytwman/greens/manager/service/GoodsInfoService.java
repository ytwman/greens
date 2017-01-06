/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:30
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.google.common.collect.Lists;
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
import org.apache.commons.lang3.StringUtils;
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
        List<GoodsInfoEntity> entities = goodsInfoMapper.selectByPagination(searchParam);
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

    public void saveOrUpdate(GoodsInfoEntity entity) {
        // 商品编码根据类目主键补位加上商品主键补位两部分组成
        // 每级类目预留两位，从左至右排列组合，例如水产（1）-鱼类（2），那么应该是0102
        // 商品补位3位，例如小黄鱼（5），那么商品编码应该是01020005

        if (entity.getId() == null) {
            goodsInfoEntityMapper.insertSelective(entity);

            // 商品编码
            String goodsCode = String.format("%02d%03d", entity.getCategoryId(), entity.getId());
            entity.setCode(goodsCode);
        } else {
            // 防止修改编码
            entity.setCode(null);
        }

        goodsInfoEntityMapper.updateByPrimaryKeySelective(entity);
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

    public boolean validateCode(String code) {
        GoodsInfoEntity goodsInfoEntity = null;

        if (StringUtils.isNotEmpty(code)) {
            goodsInfoEntity = goodsInfoMapper.selectFirstByCode(code);
        }

        return goodsInfoEntity == null;
    }
}
