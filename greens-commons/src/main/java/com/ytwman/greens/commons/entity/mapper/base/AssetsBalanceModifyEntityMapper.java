package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.AssetsBalanceModifyEntity;
import com.ytwman.greens.commons.entity.AssetsBalanceModifyEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsBalanceModifyEntityMapper {
    int countByExample(AssetsBalanceModifyEntityExample example);

    int deleteByExample(AssetsBalanceModifyEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssetsBalanceModifyEntity record);

    int insertSelective(AssetsBalanceModifyEntity record);

    List<AssetsBalanceModifyEntity> selectByExample(AssetsBalanceModifyEntityExample example);

    AssetsBalanceModifyEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssetsBalanceModifyEntity record, @Param("example") AssetsBalanceModifyEntityExample example);

    int updateByExample(@Param("record") AssetsBalanceModifyEntity record, @Param("example") AssetsBalanceModifyEntityExample example);

    int updateByPrimaryKeySelective(AssetsBalanceModifyEntity record);

    int updateByPrimaryKey(AssetsBalanceModifyEntity record);
}