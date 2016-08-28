package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.SupplierBusiness;
import com.ytwman.greens.commons.entity.SupplierBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierBusinessMapper {
    int countByExample(SupplierBusinessExample example);

    int deleteByExample(SupplierBusinessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SupplierBusiness record);

    int insertSelective(SupplierBusiness record);

    List<SupplierBusiness> selectByExample(SupplierBusinessExample example);

    SupplierBusiness selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SupplierBusiness record, @Param("example") SupplierBusinessExample example);

    int updateByExample(@Param("record") SupplierBusiness record, @Param("example") SupplierBusinessExample example);

    int updateByPrimaryKeySelective(SupplierBusiness record);

    int updateByPrimaryKey(SupplierBusiness record);
}