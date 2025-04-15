package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.JourneyGalleryImagePO;
import com.aigccafe.buterin.common.model.journey.JourneyGalleryImagePOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface JourneyGalleryImagePOMapper {
    long countByExample(JourneyGalleryImagePOExample example);

    int deleteByExample(JourneyGalleryImagePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(JourneyGalleryImagePO record);

    int insertSelective(JourneyGalleryImagePO record);

    List<JourneyGalleryImagePO> selectByExampleWithRowbounds(JourneyGalleryImagePOExample example, RowBounds rowBounds);

    List<JourneyGalleryImagePO> selectByExample(JourneyGalleryImagePOExample example);

    JourneyGalleryImagePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") JourneyGalleryImagePO record, @Param("example") JourneyGalleryImagePOExample example);

    int updateByExample(@Param("record") JourneyGalleryImagePO record, @Param("example") JourneyGalleryImagePOExample example);

    int updateByPrimaryKeySelective(JourneyGalleryImagePO record);

    int updateByPrimaryKey(JourneyGalleryImagePO record);
}