package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.JourneyTaskLogPO;
import com.aigccafe.buterin.common.model.journey.JourneyTaskLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface JourneyTaskLogPOMapper {
    long countByExample(JourneyTaskLogPOExample example);

    int deleteByExample(JourneyTaskLogPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneyTaskLogPO record);

    int insertSelective(JourneyTaskLogPO record);

    List<JourneyTaskLogPO> selectByExampleWithBLOBsWithRowbounds(JourneyTaskLogPOExample example, RowBounds rowBounds);

    List<JourneyTaskLogPO> selectByExampleWithBLOBs(JourneyTaskLogPOExample example);

    List<JourneyTaskLogPO> selectByExampleWithRowbounds(JourneyTaskLogPOExample example, RowBounds rowBounds);

    List<JourneyTaskLogPO> selectByExample(JourneyTaskLogPOExample example);

    JourneyTaskLogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneyTaskLogPO record, @Param("example") JourneyTaskLogPOExample example);

    int updateByExampleWithBLOBs(@Param("record") JourneyTaskLogPO record, @Param("example") JourneyTaskLogPOExample example);

    int updateByExample(@Param("record") JourneyTaskLogPO record, @Param("example") JourneyTaskLogPOExample example);

    int updateByPrimaryKeySelective(JourneyTaskLogPO record);

    int updateByPrimaryKeyWithBLOBs(JourneyTaskLogPO record);

    int updateByPrimaryKey(JourneyTaskLogPO record);
}