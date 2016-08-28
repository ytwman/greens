package com.ytwman.greens.ups.entity.mapper.base;

import com.ytwman.greens.ups.entity.UpsRolePermission;
import com.ytwman.greens.ups.entity.UpsRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpsRolePermissionMapper {
    int countByExample(UpsRolePermissionExample example);

    int deleteByExample(UpsRolePermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UpsRolePermission record);

    int insertSelective(UpsRolePermission record);

    List<UpsRolePermission> selectByExample(UpsRolePermissionExample example);

    UpsRolePermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UpsRolePermission record, @Param("example") UpsRolePermissionExample example);

    int updateByExample(@Param("record") UpsRolePermission record, @Param("example") UpsRolePermissionExample example);

    int updateByPrimaryKeySelective(UpsRolePermission record);

    int updateByPrimaryKey(UpsRolePermission record);
}