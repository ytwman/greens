/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 上午2:32
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.core.web.Pagination;
import com.ytwman.greens.commons.entity.GoodsInfoEntity;
import org.apache.ibatis.annotations.Param;

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
     * @param keywords   关键字（商品名称、编码、拼音缩写）
     * @param categoryId 商品类目主键
     * @param pagination 分页信息
     * @return
     */
    List<GoodsInfoEntity> selectByPagination(@Param("keywords") String keywords,
                                             @Param("categoryId") Long categoryId,
                                             @Param("page") Pagination pagination);

}
