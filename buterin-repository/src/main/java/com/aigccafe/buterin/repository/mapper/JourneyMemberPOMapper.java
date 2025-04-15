package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.JourneyMemberPO;
import com.aigccafe.buterin.common.model.journey.JourneyMemberPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface JourneyMemberPOMapper {
    long countByExample(JourneyMemberPOExample example);

    int deleteByExample(JourneyMemberPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneyMemberPO record);

    int insertSelective(JourneyMemberPO record);

    List<JourneyMemberPO> selectByExampleWithRowbounds(JourneyMemberPOExample example, RowBounds rowBounds);

    List<JourneyMemberPO> selectByExample(JourneyMemberPOExample example);

    JourneyMemberPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneyMemberPO record, @Param("example") JourneyMemberPOExample example);

    int updateByExample(@Param("record") JourneyMemberPO record, @Param("example") JourneyMemberPOExample example);

    int updateByPrimaryKeySelective(JourneyMemberPO record);

    int updateByPrimaryKey(JourneyMemberPO record);
}