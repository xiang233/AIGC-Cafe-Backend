package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.interaction.InteractionStatPO;
import com.aigccafe.buterin.common.model.interaction.InteractionStatPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface InteractionStatPOMapper {
    long countByExample(InteractionStatPOExample example);

    int deleteByExample(InteractionStatPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InteractionStatPO record);

    int insertSelective(InteractionStatPO record);

    List<InteractionStatPO> selectByExampleWithRowbounds(InteractionStatPOExample example, RowBounds rowBounds);

    List<InteractionStatPO> selectByExample(InteractionStatPOExample example);

    InteractionStatPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InteractionStatPO record, @Param("example") InteractionStatPOExample example);

    int updateByExample(@Param("record") InteractionStatPO record, @Param("example") InteractionStatPOExample example);

    int updateByPrimaryKeySelective(InteractionStatPO record);

    int updateByPrimaryKey(InteractionStatPO record);
}