package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.UserEcobagEntity;
import com.ytwman.greens.commons.entity.UserEcobagEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserEcobagEntityMapper {
    int countByExample(UserEcobagEntityExample example);

    int deleteByExample(UserEcobagEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserEcobagEntity record);

    int insertSelective(UserEcobagEntity record);

    List<UserEcobagEntity> selectByExample(UserEcobagEntityExample example);

    UserEcobagEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserEcobagEntity record, @Param("example") UserEcobagEntityExample example);

    int updateByExample(@Param("record") UserEcobagEntity record, @Param("example") UserEcobagEntityExample example);

    int updateByPrimaryKeySelective(UserEcobagEntity record);

    int updateByPrimaryKey(UserEcobagEntity record);
}