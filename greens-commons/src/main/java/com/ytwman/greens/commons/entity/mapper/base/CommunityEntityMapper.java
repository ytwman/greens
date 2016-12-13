package com.ytwman.greens.commons.entity.mapper.base;

import com.ytwman.greens.commons.entity.CommunityEntity;
import com.ytwman.greens.commons.entity.CommunityEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommunityEntityMapper {
    int countByExample(CommunityEntityExample example);

    int deleteByExample(CommunityEntityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommunityEntity record);

    int insertSelective(CommunityEntity record);

    List<CommunityEntity> selectByExample(CommunityEntityExample example);

    CommunityEntity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommunityEntity record, @Param("example") CommunityEntityExample example);

    int updateByExample(@Param("record") CommunityEntity record, @Param("example") CommunityEntityExample example);

    int updateByPrimaryKeySelective(CommunityEntity record);

    int updateByPrimaryKey(CommunityEntity record);
}