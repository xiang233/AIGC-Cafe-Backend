package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.JourneyShortUrlPO;
import com.aigccafe.buterin.common.model.journey.JourneyShortUrlPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface JourneyShortUrlPOMapper {
    long countByExample(JourneyShortUrlPOExample example);

    int deleteByExample(JourneyShortUrlPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneyShortUrlPO record);

    int insertSelective(JourneyShortUrlPO record);

    List<JourneyShortUrlPO> selectByExampleWithRowbounds(JourneyShortUrlPOExample example, RowBounds rowBounds);

    List<JourneyShortUrlPO> selectByExample(JourneyShortUrlPOExample example);

    JourneyShortUrlPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneyShortUrlPO record, @Param("example") JourneyShortUrlPOExample example);

    int updateByExample(@Param("record") JourneyShortUrlPO record, @Param("example") JourneyShortUrlPOExample example);

    int updateByPrimaryKeySelective(JourneyShortUrlPO record);

    int updateByPrimaryKey(JourneyShortUrlPO record);
}