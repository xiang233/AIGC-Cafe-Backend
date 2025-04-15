package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.md.StableGalleryImagePO;
import com.aigccafe.buterin.common.model.md.StableGalleryImagePOExample;
import com.aigccafe.buterin.common.model.md.StableGalleryImagePOWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface StableGalleryImagePOMapper {
    long countByExample(StableGalleryImagePOExample example);

    int deleteByExample(StableGalleryImagePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StableGalleryImagePOWithBLOBs record);

    int insertSelective(StableGalleryImagePOWithBLOBs record);

    List<StableGalleryImagePOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(StableGalleryImagePOExample example, RowBounds rowBounds);

    List<StableGalleryImagePOWithBLOBs> selectByExampleWithBLOBs(StableGalleryImagePOExample example);

    List<StableGalleryImagePO> selectByExampleWithRowbounds(StableGalleryImagePOExample example, RowBounds rowBounds);

    List<StableGalleryImagePO> selectByExample(StableGalleryImagePOExample example);

    StableGalleryImagePOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StableGalleryImagePOWithBLOBs record, @Param("example") StableGalleryImagePOExample example);

    int updateByExampleWithBLOBs(@Param("record") StableGalleryImagePOWithBLOBs record, @Param("example") StableGalleryImagePOExample example);

    int updateByExample(@Param("record") StableGalleryImagePO record, @Param("example") StableGalleryImagePOExample example);

    int updateByPrimaryKeySelective(StableGalleryImagePOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(StableGalleryImagePOWithBLOBs record);

    int updateByPrimaryKey(StableGalleryImagePO record);
}