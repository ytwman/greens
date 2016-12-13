package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.PurchaseSupplierEntity;
import com.ytwman.greens.commons.entity.PurchaseSupplierEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseSupplierEntityMapper {
    int countByExample(PurchaseSupplierEntityExample example);

    int deleteByExample(PurchaseSupplierEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseSupplierEntity record);

    int insertSelective(PurchaseSupplierEntity record);

    List<PurchaseSupplierEntity> selectByExample(PurchaseSupplierEntityExample example);

    PurchaseSupplierEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseSupplierEntity record, @Param("example") PurchaseSupplierEntityExample example);

    int updateByExample(@Param("record") PurchaseSupplierEntity record, @Param("example") PurchaseSupplierEntityExample example);

    int updateByPrimaryKeySelective(PurchaseSupplierEntity record);

    int updateByPrimaryKey(PurchaseSupplierEntity record);
}