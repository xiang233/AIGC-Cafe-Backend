package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.JourneyTaskPO;
import com.aigccafe.buterin.common.model.journey.JourneyTaskPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface JourneyTaskPOMapper {
    long countByExample(JourneyTaskPOExample example);

    int deleteByExample(JourneyTaskPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneyTaskPO record);

    int insertSelective(JourneyTaskPO record);

    List<JourneyTaskPO> selectByExampleWithRowbounds(JourneyTaskPOExample example, RowBounds rowBounds);

    List<JourneyTaskPO> selectByExample(JourneyTaskPOExample example);

    JourneyTaskPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneyTaskPO record, @Param("example") JourneyTaskPOExample example);

    int updateByExample(@Param("record") JourneyTaskPO record, @Param("example") JourneyTaskPOExample example);

    int updateByPrimaryKeySelective(JourneyTaskPO record);

    int updateByPrimaryKey(JourneyTaskPO record);
}