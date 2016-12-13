package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.PurchaseOrderEntity;
import com.ytwman.greens.commons.entity.PurchaseOrderEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderEntityMapper {
    int countByExample(PurchaseOrderEntityExample example);

    int deleteByExample(PurchaseOrderEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseOrderEntity record);

    int insertSelective(PurchaseOrderEntity record);

    List<PurchaseOrderEntity> selectByExample(PurchaseOrderEntityExample example);

    PurchaseOrderEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseOrderEntity record, @Param("example") PurchaseOrderEntityExample example);

    int updateByExample(@Param("record") PurchaseOrderEntity record, @Param("example") PurchaseOrderEntityExample example);

    int updateByPrimaryKeySelective(PurchaseOrderEntity record);

    int updateByPrimaryKey(PurchaseOrderEntity record);
}