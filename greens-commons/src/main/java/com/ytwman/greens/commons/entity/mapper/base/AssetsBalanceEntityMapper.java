package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.AssetsBalanceEntity;
import com.ytwman.greens.commons.entity.AssetsBalanceEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsBalanceEntityMapper {
    int countByExample(AssetsBalanceEntityExample example);

    int deleteByExample(AssetsBalanceEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssetsBalanceEntity record);

    int insertSelective(AssetsBalanceEntity record);

    List<AssetsBalanceEntity> selectByExample(AssetsBalanceEntityExample example);

    AssetsBalanceEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssetsBalanceEntity record, @Param("example") AssetsBalanceEntityExample example);

    int updateByExample(@Param("record") AssetsBalanceEntity record, @Param("example") AssetsBalanceEntityExample example);

    int updateByPrimaryKeySelective(AssetsBalanceEntity record);

    int updateByPrimaryKey(AssetsBalanceEntity record);
}