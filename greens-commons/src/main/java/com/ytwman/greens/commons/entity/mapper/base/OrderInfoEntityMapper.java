package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.OrderInfoEntity;
import com.ytwman.greens.commons.entity.OrderInfoEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderInfoEntityMapper {
    int countByExample(OrderInfoEntityExample example);

    int deleteByExample(OrderInfoEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderInfoEntity record);

    int insertSelective(OrderInfoEntity record);

    List<OrderInfoEntity> selectByExample(OrderInfoEntityExample example);

    OrderInfoEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderInfoEntity record, @Param("example") OrderInfoEntityExample example);

    int updateByExample(@Param("record") OrderInfoEntity record, @Param("example") OrderInfoEntityExample example);

    int updateByPrimaryKeySelective(OrderInfoEntity record);

    int updateByPrimaryKey(OrderInfoEntity record);
}