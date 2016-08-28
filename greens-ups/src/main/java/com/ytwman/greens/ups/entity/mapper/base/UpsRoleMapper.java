package com.ytwman.greens.ups.entity.mapper.base;

import com.ytwman.greens.ups.entity.UpsRole;
import com.ytwman.greens.ups.entity.UpsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpsRoleMapper {
    int countByExample(UpsRoleExample example);

    int deleteByExample(UpsRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UpsRole record);

    int insertSelective(UpsRole record);

    List<UpsRole> selectByExample(UpsRoleExample example);

    UpsRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UpsRole record, @Param("example") UpsRoleExample example);

    int updateByExample(@Param("record") UpsRole record, @Param("example") UpsRoleExample example);

    int updateByPrimaryKeySelective(UpsRole record);

    int updateByPrimaryKey(UpsRole record);
}