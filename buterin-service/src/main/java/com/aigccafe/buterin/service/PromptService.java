package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.enumerate.PromptType;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.common.model.resp.MjPromptDetailRespVO;
import com.aigccafe.buterin.common.model.resp.MjPromptRespVO;
import com.aigccafe.buterin.common.model.resp.SdPromptDetailRespVO;
import com.aigccafe.buterin.common.model.resp.SdPromptRespVO;

import java.util.List;

public interface PromptService {

    List<SdPromptRespVO> getPromptListByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType);

    List<SdPromptRespVO> getSdPromptListByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType, PromptStatus status);

    List<MjPromptRespVO> getMjPromptListByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType, PromptStatus status);

    SdPromptDetailRespVO getSdPromptDetail(Long promptId);

    MjPromptDetailRespVO getMjPromptDetail(Long promptId);

    List<SdPromptRespVO> searchSdPromptList(String keyword, Integer offset, Integer number);

    List<MjPromptRespVO> searchMjPromptList(String keyword, Integer offset, Integer number);

    Boolean updatePromptStatus(PromptType type, Long promptId, PromptStatus promptStatus);

    String translateSdPrompt(Long promptId);

    String translateMjPrompt(Long promptId);

    List<String> splitMjPrompt(String prompt);

    String translateMjPromptToEnglish(String prompt);
}
