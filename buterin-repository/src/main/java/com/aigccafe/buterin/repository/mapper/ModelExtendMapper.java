package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.model.md.ModelFileCountPO;
import com.aigccafe.buterin.common.model.md.SimpleImagePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModelExtendMapper {

    @Select("select model_id as modelId,count(distinct version_id) as versionCnt,count(1) as fileCnt,count(if(url='',1,0)) as unTransferFileCnt from model_version_file where model_id in (${modelIdList}) and is_deleted=0 group by model_id limit 100")
    List<ModelFileCountPO> countModelFile(@Param("modelIdList") String modelIdList);

    @Select("select id, version_id as versionId, normal_path as normalPath from model_version_image where model_id=${modelId} and is_deleted=0")
    List<SimpleImagePO> selectSimpleImageByModelId(@Param("modelId") Long modelId);


    @Select("select id, version_id as versionId, normal_path as normalPath,meta from model_version_image where version_id=${versionId} and is_deleted=0")
    List<SimpleImagePO> selectSimpleImageByVersionId(@Param("versionId") Long versionId);

    @Select("<script> select * from model_detail where MATCH(manual_tags) AGAINST('${channel}' IN BOOLEAN MODE) <if test='baseModelList != null'> AND base_model in (${baseModelList}) </if> <if test='modelTypeList != null'> AND type in (${modelTypeList}) </if> AND status='ONLINE' AND is_deleted=0 ORDER BY ${orderField} DESC LIMIT #{offset}, #{number} </script>")
    List<ModelDetailPO> selectModelListByChannel(@Param("channel") String channel, @Param("baseModelList") String baseModelList, @Param("modelTypeList") String modelTypeList, @Param("offset") int offset, @Param("number") int number, @Param("orderField") String orderField);

    @Select("select * from model_detail where MATCH(manual_tags,model_name,chn_model_name,author_name) AGAINST('${keyword}' IN BOOLEAN MODE) AND status='ONLINE' AND is_deleted=0 ORDER BY download_cnt DESC LIMIT #{offset}, #{number}")
    List<ModelDetailPO> searchModelList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("number") int number);

}
