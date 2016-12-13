package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.AssetsPointModifyEntity;
import com.ytwman.greens.commons.entity.AssetsPointModifyEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsPointModifyEntityMapper {
    int countByExample(AssetsPointModifyEntityExample example);

    int deleteByExample(AssetsPointModifyEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssetsPointModifyEntity record);

    int insertSelective(AssetsPointModifyEntity record);

    List<AssetsPointModifyEntity> selectByExample(AssetsPointModifyEntityExample example);

    AssetsPointModifyEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssetsPointModifyEntity record, @Param("example") AssetsPointModifyEntityExample example);

    int updateByExample(@Param("record") AssetsPointModifyEntity record, @Param("example") AssetsPointModifyEntityExample example);

    int updateByPrimaryKeySelective(AssetsPointModifyEntity record);

    int updateByPrimaryKey(AssetsPointModifyEntity record);
}