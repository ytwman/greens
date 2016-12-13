package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.OrderCancelEntity;
import com.ytwman.greens.commons.entity.OrderCancelEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderCancelEntityMapper {
    int countByExample(OrderCancelEntityExample example);

    int deleteByExample(OrderCancelEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCancelEntity record);

    int insertSelective(OrderCancelEntity record);

    List<OrderCancelEntity> selectByExample(OrderCancelEntityExample example);

    OrderCancelEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCancelEntity record, @Param("example") OrderCancelEntityExample example);

    int updateByExample(@Param("record") OrderCancelEntity record, @Param("example") OrderCancelEntityExample example);

    int updateByPrimaryKeySelective(OrderCancelEntity record);

    int updateByPrimaryKey(OrderCancelEntity record);
}