package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.GoodsInfoEntity;
import com.ytwman.greens.commons.entity.GoodsInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsInfoEntityMapper {
    int countByExample(GoodsInfoEntityExample example);

    int deleteByExample(GoodsInfoEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfoEntity record);

    int insertSelective(GoodsInfoEntity record);

    List<GoodsInfoEntity> selectByExample(GoodsInfoEntityExample example);

    GoodsInfoEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsInfoEntity record, @Param("example") GoodsInfoEntityExample example);

    int updateByExample(@Param("record") GoodsInfoEntity record, @Param("example") GoodsInfoEntityExample example);

    int updateByPrimaryKeySelective(GoodsInfoEntity record);

    int updateByPrimaryKey(GoodsInfoEntity record);
}