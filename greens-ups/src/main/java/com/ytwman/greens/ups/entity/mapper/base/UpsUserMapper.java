package com.ytwman.greens.ups.entity.mapper.base;

import com.ytwman.greens.ups.entity.UpsUser;
import com.ytwman.greens.ups.entity.UpsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpsUserMapper {
    int countByExample(UpsUserExample example);

    int deleteByExample(UpsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UpsUser record);

    int insertSelective(UpsUser record);

    List<UpsUser> selectByExample(UpsUserExample example);

    UpsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UpsUser record, @Param("example") UpsUserExample example);

    int updateByExample(@Param("record") UpsUser record, @Param("example") UpsUserExample example);

    int updateByPrimaryKeySelective(UpsUser record);

    int updateByPrimaryKey(UpsUser record);
}