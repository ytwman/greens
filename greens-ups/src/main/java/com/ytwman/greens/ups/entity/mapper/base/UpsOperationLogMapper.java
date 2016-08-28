package com.ytwman.greens.ups.entity.mapper.base;

import com.ytwman.greens.ups.entity.UpsOperationLog;
import com.ytwman.greens.ups.entity.UpsOperationLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpsOperationLogMapper {
    int countByExample(UpsOperationLogExample example);

    int deleteByExample(UpsOperationLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UpsOperationLog record);

    int insertSelective(UpsOperationLog record);

    List<UpsOperationLog> selectByExample(UpsOperationLogExample example);

    UpsOperationLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UpsOperationLog record, @Param("example") UpsOperationLogExample example);

    int updateByExample(@Param("record") UpsOperationLog record, @Param("example") UpsOperationLogExample example);

    int updateByPrimaryKeySelective(UpsOperationLog record);

    int updateByPrimaryKey(UpsOperationLog record);
}