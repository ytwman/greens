package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.UserAccountEntity;
import com.ytwman.greens.commons.entity.UserAccountEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountEntityMapper {
    int countByExample(UserAccountEntityExample example);

    int deleteByExample(UserAccountEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAccountEntity record);

    int insertSelective(UserAccountEntity record);

    List<UserAccountEntity> selectByExample(UserAccountEntityExample example);

    UserAccountEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAccountEntity record, @Param("example") UserAccountEntityExample example);

    int updateByExample(@Param("record") UserAccountEntity record, @Param("example") UserAccountEntityExample example);

    int updateByPrimaryKeySelective(UserAccountEntity record);

    int updateByPrimaryKey(UserAccountEntity record);
}