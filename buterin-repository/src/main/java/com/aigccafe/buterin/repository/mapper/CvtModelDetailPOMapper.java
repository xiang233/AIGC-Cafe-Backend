package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.cvt.CvtModelDetailPO;
import com.aigccafe.buterin.common.model.cvt.CvtModelDetailPOExample;
import com.aigccafe.buterin.common.model.cvt.CvtModelDetailPOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface CvtModelDetailPOMapper {
    long countByExample(CvtModelDetailPOExample example);

    int deleteByExample(CvtModelDetailPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CvtModelDetailPOWithBLOBs record);

    int insertSelective(CvtModelDetailPOWithBLOBs record);

    List<CvtModelDetailPOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(CvtModelDetailPOExample example, RowBounds rowBounds);

    List<CvtModelDetailPOWithBLOBs> selectByExampleWithBLOBs(CvtModelDetailPOExample example);

    List<CvtModelDetailPO> selectByExampleWithRowbounds(CvtModelDetailPOExample example, RowBounds rowBounds);

    List<CvtModelDetailPO> selectByExample(CvtModelDetailPOExample example);

    CvtModelDetailPOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CvtModelDetailPOWithBLOBs record, @Param("example") CvtModelDetailPOExample example);

    int updateByExampleWithBLOBs(@Param("record") CvtModelDetailPOWithBLOBs record, @Param("example") CvtModelDetailPOExample example);

    int updateByExample(@Param("record") CvtModelDetailPO record, @Param("example") CvtModelDetailPOExample example);

    int updateByPrimaryKeySelective(CvtModelDetailPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CvtModelDetailPOWithBLOBs record);

    int updateByPrimaryKey(CvtModelDetailPO record);
}