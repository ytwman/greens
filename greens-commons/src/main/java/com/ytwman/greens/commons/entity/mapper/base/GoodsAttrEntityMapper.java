package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.GoodsAttrEntity;
import com.ytwman.greens.commons.entity.GoodsAttrEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsAttrEntityMapper {
    int countByExample(GoodsAttrEntityExample example);

    int deleteByExample(GoodsAttrEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsAttrEntity record);

    int insertSelective(GoodsAttrEntity record);

    List<GoodsAttrEntity> selectByExample(GoodsAttrEntityExample example);

    GoodsAttrEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsAttrEntity record, @Param("example") GoodsAttrEntityExample example);

    int updateByExample(@Param("record") GoodsAttrEntity record, @Param("example") GoodsAttrEntityExample example);

    int updateByPrimaryKeySelective(GoodsAttrEntity record);

    int updateByPrimaryKey(GoodsAttrEntity record);
}