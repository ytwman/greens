package com.ytwman.greens.ups.entity.mapper.base;

import com.ytwman.greens.ups.entity.UpsPermission;
import com.ytwman.greens.ups.entity.UpsPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpsPermissionMapper {
    int countByExample(UpsPermissionExample example);

    int deleteByExample(UpsPermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UpsPermission record);

    int insertSelective(UpsPermission record);

    List<UpsPermission> selectByExample(UpsPermissionExample example);

    UpsPermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UpsPermission record, @Param("example") UpsPermissionExample example);

    int updateByExample(@Param("record") UpsPermission record, @Param("example") UpsPermissionExample example);

    int updateByPrimaryKeySelective(UpsPermission record);

    int updateByPrimaryKey(UpsPermission record);
}