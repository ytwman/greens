package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.OrderItemEntity;
import com.ytwman.greens.commons.entity.OrderItemEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemEntityMapper {
    int countByExample(OrderItemEntityExample example);

    int deleteByExample(OrderItemEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderItemEntity record);

    int insertSelective(OrderItemEntity record);

    List<OrderItemEntity> selectByExample(OrderItemEntityExample example);

    OrderItemEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderItemEntity record, @Param("example") OrderItemEntityExample example);

    int updateByExample(@Param("record") OrderItemEntity record, @Param("example") OrderItemEntityExample example);

    int updateByPrimaryKeySelective(OrderItemEntity record);

    int updateByPrimaryKey(OrderItemEntity record);
}