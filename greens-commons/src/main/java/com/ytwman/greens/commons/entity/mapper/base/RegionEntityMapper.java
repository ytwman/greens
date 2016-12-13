package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.RegionEntity;
import com.ytwman.greens.commons.entity.RegionEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionEntityMapper {
    int countByExample(RegionEntityExample example);

    int deleteByExample(RegionEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RegionEntity record);

    int insertSelective(RegionEntity record);

    List<RegionEntity> selectByExample(RegionEntityExample example);

    RegionEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RegionEntity record, @Param("example") RegionEntityExample example);

    int updateByExample(@Param("record") RegionEntity record, @Param("example") RegionEntityExample example);

    int updateByPrimaryKeySelective(RegionEntity record);

    int updateByPrimaryKey(RegionEntity record);
}