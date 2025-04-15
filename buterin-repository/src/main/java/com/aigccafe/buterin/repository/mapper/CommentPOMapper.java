package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.comment.CommentPO;
import com.aigccafe.buterin.common.model.comment.CommentPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface CommentPOMapper {
    long countByExample(CommentPOExample example);

    int deleteByExample(CommentPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentPO record);

    int insertSelective(CommentPO record);

    List<CommentPO> selectByExampleWithBLOBsWithRowbounds(CommentPOExample example, RowBounds rowBounds);

    List<CommentPO> selectByExampleWithBLOBs(CommentPOExample example);

    List<CommentPO> selectByExampleWithRowbounds(CommentPOExample example, RowBounds rowBounds);

    List<CommentPO> selectByExample(CommentPOExample example);

    CommentPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommentPO record, @Param("example") CommentPOExample example);

    int updateByExampleWithBLOBs(@Param("record") CommentPO record, @Param("example") CommentPOExample example);

    int updateByExample(@Param("record") CommentPO record, @Param("example") CommentPOExample example);

    int updateByPrimaryKeySelective(CommentPO record);

    int updateByPrimaryKeyWithBLOBs(CommentPO record);

    int updateByPrimaryKey(CommentPO record);
}