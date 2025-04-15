package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.model.md.ModelDetailPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface ModelDetailPOMapper {
    long countByExample(ModelDetailPOExample example);

    int deleteByExample(ModelDetailPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ModelDetailPO record);

    int insertSelective(ModelDetailPO record);

    List<ModelDetailPO> selectByExampleWithRowbounds(ModelDetailPOExample example, RowBounds rowBounds);

    List<ModelDetailPO> selectByExample(ModelDetailPOExample example);

    ModelDetailPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModelDetailPO record, @Param("example") ModelDetailPOExample example);

    int updateByExample(@Param("record") ModelDetailPO record, @Param("example") ModelDetailPOExample example);

    int updateByPrimaryKeySelective(ModelDetailPO record);

    int updateByPrimaryKey(ModelDetailPO record);
}