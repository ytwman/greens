package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.OrderOfferEntity;
import com.ytwman.greens.commons.entity.OrderOfferEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderOfferEntityMapper {
    int countByExample(OrderOfferEntityExample example);

    int deleteByExample(OrderOfferEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderOfferEntity record);

    int insertSelective(OrderOfferEntity record);

    List<OrderOfferEntity> selectByExample(OrderOfferEntityExample example);

    OrderOfferEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderOfferEntity record, @Param("example") OrderOfferEntityExample example);

    int updateByExample(@Param("record") OrderOfferEntity record, @Param("example") OrderOfferEntityExample example);

    int updateByPrimaryKeySelective(OrderOfferEntity record);

    int updateByPrimaryKey(OrderOfferEntity record);
}