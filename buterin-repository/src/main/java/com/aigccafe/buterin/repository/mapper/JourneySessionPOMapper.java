package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.JourneySessionPO;
import com.aigccafe.buterin.common.model.journey.JourneySessionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface JourneySessionPOMapper {
    long countByExample(JourneySessionPOExample example);

    int deleteByExample(JourneySessionPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneySessionPO record);

    int insertSelective(JourneySessionPO record);

    List<JourneySessionPO> selectByExampleWithRowbounds(JourneySessionPOExample example, RowBounds rowBounds);

    List<JourneySessionPO> selectByExample(JourneySessionPOExample example);

    JourneySessionPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneySessionPO record, @Param("example") JourneySessionPOExample example);

    int updateByExample(@Param("record") JourneySessionPO record, @Param("example") JourneySessionPOExample example);

    int updateByPrimaryKeySelective(JourneySessionPO record);

    int updateByPrimaryKey(JourneySessionPO record);
}