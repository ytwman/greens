package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.UserFamilyEntity;
import com.ytwman.greens.commons.entity.UserFamilyEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserFamilyEntityMapper {
    int countByExample(UserFamilyEntityExample example);

    int deleteByExample(UserFamilyEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFamilyEntity record);

    int insertSelective(UserFamilyEntity record);

    List<UserFamilyEntity> selectByExample(UserFamilyEntityExample example);

    UserFamilyEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFamilyEntity record, @Param("example") UserFamilyEntityExample example);

    int updateByExample(@Param("record") UserFamilyEntity record, @Param("example") UserFamilyEntityExample example);

    int updateByPrimaryKeySelective(UserFamilyEntity record);

    int updateByPrimaryKey(UserFamilyEntity record);
}