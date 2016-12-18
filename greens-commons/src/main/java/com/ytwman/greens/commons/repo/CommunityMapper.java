/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/15 上午9:46
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.CommunityEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CommunityMapper {

    /**
     * 根据主键查询
     *
     * @param regionId 地区编码
     * @param keywords 检索关键字
     * @return
     */
    CommunityEntity findByRegion(@Param("regionId") Long regionId, @Param("keywords") String keywords);

}
