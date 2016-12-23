package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.UserInfoExtEntity;
import com.ytwman.greens.commons.entity.UserInfoExtEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoExtEntityMapper {
    int countByExample(UserInfoExtEntityExample example);

    int deleteByExample(UserInfoExtEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfoExtEntity record);

    int insertSelective(UserInfoExtEntity record);

    List<UserInfoExtEntity> selectByExample(UserInfoExtEntityExample example);

    UserInfoExtEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfoExtEntity record, @Param("example") UserInfoExtEntityExample example);

    int updateByExample(@Param("record") UserInfoExtEntity record, @Param("example") UserInfoExtEntityExample example);

    int updateByPrimaryKeySelective(UserInfoExtEntity record);

    int updateByPrimaryKey(UserInfoExtEntity record);
}