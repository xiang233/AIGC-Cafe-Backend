package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.cvt.CvtModelDetectPO;
import com.aigccafe.buterin.common.model.cvt.CvtModelDetectPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface CvtModelDetectPOMapper {
    long countByExample(CvtModelDetectPOExample example);

    int deleteByExample(CvtModelDetectPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CvtModelDetectPO record);

    int insertSelective(CvtModelDetectPO record);

    List<CvtModelDetectPO> selectByExampleWithRowbounds(CvtModelDetectPOExample example, RowBounds rowBounds);

    List<CvtModelDetectPO> selectByExample(CvtModelDetectPOExample example);

    CvtModelDetectPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CvtModelDetectPO record, @Param("example") CvtModelDetectPOExample example);

    int updateByExample(@Param("record") CvtModelDetectPO record, @Param("example") CvtModelDetectPOExample example);

    int updateByPrimaryKeySelective(CvtModelDetectPO record);

    int updateByPrimaryKey(CvtModelDetectPO record);
}