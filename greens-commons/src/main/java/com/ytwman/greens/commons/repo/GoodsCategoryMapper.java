/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/11/14 下午11:07
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.GoodsCategoryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface GoodsCategoryMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    GoodsCategoryEntity findById(@Param("id") Long id);

    /**
     * 根据主键查询节点
     *
     * @param id
     * @return
     */
    List<GoodsCategoryEntity> findByParentId(@Param("id") Long id);

    /**
     * 根据类目编码查询
     *
     * @param code
     * @param force 查询已删除
     * @return
     */
    GoodsCategoryEntity findByCode(@Param("code") String code, @Param("force") boolean force);

    /**
     * 根据关键字模糊查询商品类目(名称或编码)
     *
     * @param keywords
     * @return
     */
    List<GoodsCategoryEntity> findAll(@Param("keywords") String keywords);
}
