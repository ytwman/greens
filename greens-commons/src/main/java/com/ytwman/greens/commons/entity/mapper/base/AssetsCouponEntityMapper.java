package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.AssetsCouponEntity;
import com.ytwman.greens.commons.entity.AssetsCouponEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssetsCouponEntityMapper {
    int countByExample(AssetsCouponEntityExample example);

    int deleteByExample(AssetsCouponEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AssetsCouponEntity record);

    int insertSelective(AssetsCouponEntity record);

    List<AssetsCouponEntity> selectByExample(AssetsCouponEntityExample example);

    AssetsCouponEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AssetsCouponEntity record, @Param("example") AssetsCouponEntityExample example);

    int updateByExample(@Param("record") AssetsCouponEntity record, @Param("example") AssetsCouponEntityExample example);

    int updateByPrimaryKeySelective(AssetsCouponEntity record);

    int updateByPrimaryKey(AssetsCouponEntity record);
}