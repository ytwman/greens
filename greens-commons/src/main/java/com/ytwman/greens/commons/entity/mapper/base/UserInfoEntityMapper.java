package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.UserInfoEntity;
import com.ytwman.greens.commons.entity.UserInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoEntityMapper {
    int countByExample(UserInfoEntityExample example);

    int deleteByExample(UserInfoEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfoEntity record);

    int insertSelective(UserInfoEntity record);

    List<UserInfoEntity> selectByExample(UserInfoEntityExample example);

    UserInfoEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfoEntity record, @Param("example") UserInfoEntityExample example);

    int updateByExample(@Param("record") UserInfoEntity record, @Param("example") UserInfoEntityExample example);

    int updateByPrimaryKeySelective(UserInfoEntity record);

    int updateByPrimaryKey(UserInfoEntity record);
}