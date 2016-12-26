/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:32
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.GoodsInfoEntity;
import com.ytwman.greens.commons.model.GoodsInfoSearch;

import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface GoodsInfoMapper {

    /**
     * 查询分页商品
     *
     * @param search
     * @return
     */
    List<GoodsInfoEntity> selectByPagination(GoodsInfoSearch search);

}
