package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.GoodsCategoryEntity;
import com.ytwman.greens.commons.entity.GoodsCategoryEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCategoryEntityMapper {
    int countByExample(GoodsCategoryEntityExample example);

    int deleteByExample(GoodsCategoryEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategoryEntity record);

    int insertSelective(GoodsCategoryEntity record);

    List<GoodsCategoryEntity> selectByExample(GoodsCategoryEntityExample example);

    GoodsCategoryEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsCategoryEntity record, @Param("example") GoodsCategoryEntityExample example);

    int updateByExample(@Param("record") GoodsCategoryEntity record, @Param("example") GoodsCategoryEntityExample example);

    int updateByPrimaryKeySelective(GoodsCategoryEntity record);

    int updateByPrimaryKey(GoodsCategoryEntity record);
}