/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * Author:  忽忽(huhu)
 * Date:    16/12/16 上午12:22
 * Description: 
 */
package com.ytwman.greens.commons.repo;

import com.ytwman.greens.commons.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 忽忽(huhu)
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserInfoMapper {

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    UserInfoEntity findById(@Param("id") Long id);

    /**
     * 根据关键字模糊查询(名称或手机号码)
     *
     * @param keywords
     * @param communityId 社区编号
     * @return
     */
    List<UserInfoEntity> findAll(@Param("keywords") String keywords, @Param("communityId") Long communityId);

}
