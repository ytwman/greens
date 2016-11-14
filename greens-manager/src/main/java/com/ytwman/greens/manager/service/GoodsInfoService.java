/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:30
 * Description: 
 */
package com.ytwman.greens.manager.service;

import com.ytwman.greens.commons.Pagination;
import com.ytwman.greens.commons.entity.GoodsInfoEntity;
import com.ytwman.greens.commons.entity.mapper.base.GoodsInfoEntityMapper;
import com.ytwman.greens.commons.repo.GoodsInfoMapper;
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
    GoodsInfoEntityMapper goodsInfoEntityMapper;

    @Resource
    GoodsInfoMapper goodsInfoMapper;

    public List<GoodsInfoEntity> getAll(Pagination pagination) {
        return goodsInfoMapper.selectByPagination(pagination.getOffset(), pagination.getLimit());
    }

    public GoodsInfoEntity get(Long goodsId) {
        return goodsInfoEntityMapper.selectByPrimaryKey(goodsId);
    }
}
