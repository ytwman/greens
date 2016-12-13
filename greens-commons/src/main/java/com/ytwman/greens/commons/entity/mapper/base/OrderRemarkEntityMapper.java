package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.OrderRemarkEntity;
import com.ytwman.greens.commons.entity.OrderRemarkEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderRemarkEntityMapper {
    int countByExample(OrderRemarkEntityExample example);

    int deleteByExample(OrderRemarkEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderRemarkEntity record);

    int insertSelective(OrderRemarkEntity record);

    List<OrderRemarkEntity> selectByExample(OrderRemarkEntityExample example);

    OrderRemarkEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderRemarkEntity record, @Param("example") OrderRemarkEntityExample example);

    int updateByExample(@Param("record") OrderRemarkEntity record, @Param("example") OrderRemarkEntityExample example);

    int updateByPrimaryKeySelective(OrderRemarkEntity record);

    int updateByPrimaryKey(OrderRemarkEntity record);
}