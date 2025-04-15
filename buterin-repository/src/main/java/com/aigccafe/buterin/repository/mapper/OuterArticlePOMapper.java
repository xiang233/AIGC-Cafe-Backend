package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.doc.OuterArticlePO;
import com.aigccafe.buterin.common.model.doc.OuterArticlePOExample;
import com.aigccafe.buterin.common.model.doc.OuterArticlePOWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface OuterArticlePOMapper {
    long countByExample(OuterArticlePOExample example);

    int deleteByExample(OuterArticlePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OuterArticlePOWithBLOBs record);

    int insertSelective(OuterArticlePOWithBLOBs record);

    List<OuterArticlePOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(OuterArticlePOExample example, RowBounds rowBounds);

    List<OuterArticlePOWithBLOBs> selectByExampleWithBLOBs(OuterArticlePOExample example);

    List<OuterArticlePO> selectByExampleWithRowbounds(OuterArticlePOExample example, RowBounds rowBounds);

    List<OuterArticlePO> selectByExample(OuterArticlePOExample example);

    OuterArticlePOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OuterArticlePOWithBLOBs record, @Param("example") OuterArticlePOExample example);

    int updateByExampleWithBLOBs(@Param("record") OuterArticlePOWithBLOBs record, @Param("example") OuterArticlePOExample example);

    int updateByExample(@Param("record") OuterArticlePO record, @Param("example") OuterArticlePOExample example);

    int updateByPrimaryKeySelective(OuterArticlePOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OuterArticlePOWithBLOBs record);

    int updateByPrimaryKey(OuterArticlePO record);
}