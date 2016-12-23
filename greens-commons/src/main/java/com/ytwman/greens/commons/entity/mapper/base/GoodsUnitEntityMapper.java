package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.GoodsUnitEntity;
import com.ytwman.greens.commons.entity.GoodsUnitEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsUnitEntityMapper {
    int countByExample(GoodsUnitEntityExample example);

    int deleteByExample(GoodsUnitEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsUnitEntity record);

    int insertSelective(GoodsUnitEntity record);

    List<GoodsUnitEntity> selectByExample(GoodsUnitEntityExample example);

    GoodsUnitEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsUnitEntity record, @Param("example") GoodsUnitEntityExample example);

    int updateByExample(@Param("record") GoodsUnitEntity record, @Param("example") GoodsUnitEntityExample example);

    int updateByPrimaryKeySelective(GoodsUnitEntity record);

    int updateByPrimaryKey(GoodsUnitEntity record);
}