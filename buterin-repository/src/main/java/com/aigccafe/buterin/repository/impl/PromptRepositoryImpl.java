package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.model.prompt.PromptTagPO;
import com.aigccafe.buterin.common.model.prompt.PromptTagPOExample;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.PromptRepository;
import com.aigccafe.buterin.repository.mapper.PromptTagPOMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PromptRepositoryImpl implements PromptRepository {

    @Autowired
    private PromptTagPOMapper promptTagPOMapper;

    @Override
    public boolean insertPromptTag(String tag, String cnTag) {
        Preconditions.checkNonEmpty(tag, "tag不能为空");
        Preconditions.checkNonEmpty(cnTag, "cnTag不能为空");
        PromptTagPO promptTagPO = new PromptTagPO();
        promptTagPO.setTags(tag);
        promptTagPO.setCnTags(cnTag);
        promptTagPO.setCreatedAt(DateTimeUtils.nowSeconds());
        promptTagPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        promptTagPO.setIsDeleted(false);
        return promptTagPOMapper.insert(promptTagPO) > 0;
    }

    @Override
    public List<PromptTagPO> selectByCondition(Integer offset, Integer number) {
        PromptTagPOExample example = new PromptTagPOExample();
        PromptTagPOExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(offset, number);
        return promptTagPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public Long countPromptTags() {
        PromptTagPOExample example = new PromptTagPOExample();
        PromptTagPOExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        return promptTagPOMapper.countByExample(example);
    }

    @Override
    public boolean deletePromptTag(Long id) {
        return promptTagPOMapper.deleteByPrimaryKey(id) > 0;
    }
}
