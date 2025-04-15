package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.interaction.SimpleInteractionPO;
import com.aigccafe.buterin.common.model.interaction.SimpleInteractionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface SimpleInteractionPOMapper {
    long countByExample(SimpleInteractionPOExample example);

    int deleteByExample(SimpleInteractionPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SimpleInteractionPO record);

    int insertSelective(SimpleInteractionPO record);

    List<SimpleInteractionPO> selectByExampleWithRowbounds(SimpleInteractionPOExample example, RowBounds rowBounds);

    List<SimpleInteractionPO> selectByExample(SimpleInteractionPOExample example);

    SimpleInteractionPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SimpleInteractionPO record, @Param("example") SimpleInteractionPOExample example);

    int updateByExample(@Param("record") SimpleInteractionPO record, @Param("example") SimpleInteractionPOExample example);

    int updateByPrimaryKeySelective(SimpleInteractionPO record);

    int updateByPrimaryKey(SimpleInteractionPO record);
}