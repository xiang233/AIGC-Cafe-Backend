package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.prompt.PromptTagPO;
import com.aigccafe.buterin.common.model.prompt.PromptTagPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface PromptTagPOMapper {
    long countByExample(PromptTagPOExample example);

    int deleteByExample(PromptTagPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PromptTagPO record);

    int insertSelective(PromptTagPO record);

    List<PromptTagPO> selectByExampleWithRowbounds(PromptTagPOExample example, RowBounds rowBounds);

    List<PromptTagPO> selectByExample(PromptTagPOExample example);

    PromptTagPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PromptTagPO record, @Param("example") PromptTagPOExample example);

    int updateByExample(@Param("record") PromptTagPO record, @Param("example") PromptTagPOExample example);

    int updateByPrimaryKeySelective(PromptTagPO record);

    int updateByPrimaryKey(PromptTagPO record);
}