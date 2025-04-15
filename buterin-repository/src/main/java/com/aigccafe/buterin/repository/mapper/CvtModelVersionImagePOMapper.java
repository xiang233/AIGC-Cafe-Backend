package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.cvt.CvtModelVersionImagePO;
import com.aigccafe.buterin.common.model.cvt.CvtModelVersionImagePOExample;
import com.aigccafe.buterin.common.model.cvt.CvtModelVersionImagePOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface CvtModelVersionImagePOMapper {
    long countByExample(CvtModelVersionImagePOExample example);

    int deleteByExample(CvtModelVersionImagePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CvtModelVersionImagePOWithBLOBs record);

    int insertSelective(CvtModelVersionImagePOWithBLOBs record);

    List<CvtModelVersionImagePOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(CvtModelVersionImagePOExample example, RowBounds rowBounds);

    List<CvtModelVersionImagePOWithBLOBs> selectByExampleWithBLOBs(CvtModelVersionImagePOExample example);

    List<CvtModelVersionImagePO> selectByExampleWithRowbounds(CvtModelVersionImagePOExample example, RowBounds rowBounds);

    List<CvtModelVersionImagePO> selectByExample(CvtModelVersionImagePOExample example);

    CvtModelVersionImagePOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CvtModelVersionImagePOWithBLOBs record, @Param("example") CvtModelVersionImagePOExample example);

    int updateByExampleWithBLOBs(@Param("record") CvtModelVersionImagePOWithBLOBs record, @Param("example") CvtModelVersionImagePOExample example);

    int updateByExample(@Param("record") CvtModelVersionImagePO record, @Param("example") CvtModelVersionImagePOExample example);

    int updateByPrimaryKeySelective(CvtModelVersionImagePOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CvtModelVersionImagePOWithBLOBs record);

    int updateByPrimaryKey(CvtModelVersionImagePO record);
}