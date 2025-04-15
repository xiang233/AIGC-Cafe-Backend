package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.journey.JourneyGalleryImagePO;
import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.model.md.StableGalleryImagePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PromptExtendMapper {

    @Select("select * from stable_gallery_image where MATCH(meta) AGAINST('${keyword}' IN BOOLEAN MODE) AND status='ONLINE' AND is_deleted=0 ORDER BY view_cnt DESC LIMIT #{offset}, #{number}")
    List<StableGalleryImagePO> searchSdPromptList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("number") int number);

    @Select("select * from journey_gallery_image where MATCH(prompt) AGAINST('${keyword}' IN BOOLEAN MODE) AND status='ONLINE' AND is_deleted=0 ORDER BY view_cnt DESC LIMIT #{offset}, #{number}")
    List<JourneyGalleryImagePO> searchMjPromptList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("number") int number);
}
