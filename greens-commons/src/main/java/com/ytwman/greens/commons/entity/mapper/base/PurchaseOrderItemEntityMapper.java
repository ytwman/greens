package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.PurchaseOrderItemEntity;
import com.ytwman.greens.commons.entity.PurchaseOrderItemEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseOrderItemEntityMapper {
    int countByExample(PurchaseOrderItemEntityExample example);

    int deleteByExample(PurchaseOrderItemEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseOrderItemEntity record);

    int insertSelective(PurchaseOrderItemEntity record);

    List<PurchaseOrderItemEntity> selectByExample(PurchaseOrderItemEntityExample example);

    PurchaseOrderItemEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseOrderItemEntity record, @Param("example") PurchaseOrderItemEntityExample example);

    int updateByExample(@Param("record") PurchaseOrderItemEntity record, @Param("example") PurchaseOrderItemEntityExample example);

    int updateByPrimaryKeySelective(PurchaseOrderItemEntity record);

    int updateByPrimaryKey(PurchaseOrderItemEntity record);
}