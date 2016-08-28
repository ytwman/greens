package com.ytwman.greens.ups.entity.mapper.base;

import com.ytwman.greens.ups.entity.UpsUserRole;
import com.ytwman.greens.ups.entity.UpsUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpsUserRoleMapper {
    int countByExample(UpsUserRoleExample example);

    int deleteByExample(UpsUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UpsUserRole record);

    int insertSelective(UpsUserRole record);

    List<UpsUserRole> selectByExample(UpsUserRoleExample example);

    UpsUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UpsUserRole record, @Param("example") UpsUserRoleExample example);

    int updateByExample(@Param("record") UpsUserRole record, @Param("example") UpsUserRoleExample example);

    int updateByPrimaryKeySelective(UpsUserRole record);

    int updateByPrimaryKey(UpsUserRole record);
}