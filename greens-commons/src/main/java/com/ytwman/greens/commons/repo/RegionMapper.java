/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/18 下午6:14
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.RegionEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface RegionMapper {

    /**
     * 根据主键查询节点
     *
     * @param parentId
     * @return
     */
    List<RegionEntity> findByParentId(@Param("parentId") Long parentId);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    RegionEntity findById(@Param("id") Long id);

    /**
     * 根据主键查询父节点
     * @param id
     * @return
     */
    RegionEntity findParentById(@Param("id") Long id);

    /**
     * 根据地区等级查询
     *
     * @param level
     * @return
     */
    List<RegionEntity> findByLevel(@Param("level") Integer level);
}
