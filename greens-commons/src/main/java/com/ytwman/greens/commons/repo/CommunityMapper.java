/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/15 上午9:46
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.CommunityEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CommunityMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    CommunityEntity findById(@Param("id") Long id);

    /**
     * 根据关键字模糊查询(名称或编码)
     *
     * @param keywords
     * @return
     */
    List<CommunityEntity> findAll(@Param("keywords") String keywords);

}
