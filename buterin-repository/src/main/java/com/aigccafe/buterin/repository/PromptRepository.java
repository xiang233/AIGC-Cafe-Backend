package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.model.prompt.PromptTagPO;

import java.util.List;

public interface PromptRepository {

    /**
     * 插入一条标签
     * @param tag  标签
     * @param cnTag 标签中文释意
     * @return 插入是否成功
     */
    boolean insertPromptTag(String tag, String cnTag);


    /**
     * 返回标签列表
     * @param offset 偏移量
     * @param number 个数
     * @return 标签列表
     */
    List<PromptTagPO> selectByCondition(Integer offset, Integer number);

    /**
     * 返回有效标签总个数
     * @return 有效标签总个数
     */
    Long countPromptTags();


    /**
     * 删除一个标签
     * @param id
     * @return 删除是否成功
     */
    boolean deletePromptTag(Long id);
}
