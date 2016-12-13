package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.AssetsPointEntity;
import com.ytwman.greens.commons.entity.AssetsPointEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsPointEntityMapper {
    int countByExample(AssetsPointEntityExample example);

    int deleteByExample(AssetsPointEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssetsPointEntity record);

    int insertSelective(AssetsPointEntity record);

    List<AssetsPointEntity> selectByExample(AssetsPointEntityExample example);

    AssetsPointEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssetsPointEntity record, @Param("example") AssetsPointEntityExample example);

    int updateByExample(@Param("record") AssetsPointEntity record, @Param("example") AssetsPointEntityExample example);

    int updateByPrimaryKeySelective(AssetsPointEntity record);

    int updateByPrimaryKey(AssetsPointEntity record);
}