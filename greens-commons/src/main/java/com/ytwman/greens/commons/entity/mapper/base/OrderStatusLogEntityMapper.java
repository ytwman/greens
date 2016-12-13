package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.OrderStatusLogEntity;
import com.ytwman.greens.commons.entity.OrderStatusLogEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderStatusLogEntityMapper {
    int countByExample(OrderStatusLogEntityExample example);

    int deleteByExample(OrderStatusLogEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderStatusLogEntity record);

    int insertSelective(OrderStatusLogEntity record);

    List<OrderStatusLogEntity> selectByExample(OrderStatusLogEntityExample example);

    OrderStatusLogEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderStatusLogEntity record, @Param("example") OrderStatusLogEntityExample example);

    int updateByExample(@Param("record") OrderStatusLogEntity record, @Param("example") OrderStatusLogEntityExample example);

    int updateByPrimaryKeySelective(OrderStatusLogEntity record);

    int updateByPrimaryKey(OrderStatusLogEntity record);
}