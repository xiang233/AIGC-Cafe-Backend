package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.MjShowcaseLogPO;
import com.aigccafe.buterin.common.model.journey.MjShowcaseLogPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface MjShowcaseLogPOMapper {
    long countByExample(MjShowcaseLogPOExample example);

    int deleteByExample(MjShowcaseLogPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MjShowcaseLogPO record);

    int insertSelective(MjShowcaseLogPO record);

    List<MjShowcaseLogPO> selectByExampleWithBLOBsWithRowbounds(MjShowcaseLogPOExample example, RowBounds rowBounds);

    List<MjShowcaseLogPO> selectByExampleWithBLOBs(MjShowcaseLogPOExample example);

    List<MjShowcaseLogPO> selectByExampleWithRowbounds(MjShowcaseLogPOExample example, RowBounds rowBounds);

    List<MjShowcaseLogPO> selectByExample(MjShowcaseLogPOExample example);

    MjShowcaseLogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MjShowcaseLogPO record, @Param("example") MjShowcaseLogPOExample example);

    int updateByExampleWithBLOBs(@Param("record") MjShowcaseLogPO record, @Param("example") MjShowcaseLogPOExample example);

    int updateByExample(@Param("record") MjShowcaseLogPO record, @Param("example") MjShowcaseLogPOExample example);

    int updateByPrimaryKeySelective(MjShowcaseLogPO record);

    int updateByPrimaryKeyWithBLOBs(MjShowcaseLogPO record);

    int updateByPrimaryKey(MjShowcaseLogPO record);
}