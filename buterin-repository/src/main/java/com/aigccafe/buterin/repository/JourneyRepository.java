package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.model.journey.*;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;

import java.util.List;

public interface JourneyRepository {

    JourneySessionPO selectSessionById(Long id);

    JourneyTaskPO selectTaskById(Long id);

    Boolean insertSession(JourneySessionPO session);

    Boolean insertTask(JourneyTaskPO journeyTaskPO);

    Boolean insertJourneyMember(JourneyMemberPO journeyMemberPO);

    Boolean insertJourneyGalleryImage(JourneyGalleryImagePO galleryImagePO);

    Boolean insertMjShowcaseLog(MjShowcaseLogPO mjShowcaseLogPO);

    Boolean updateSession(JourneySessionPO session);

    Boolean updateTask(JourneyTaskPO journeyTaskPO);

    Boolean updateJourneyMember(JourneyMemberPO journeyMemberPO);

    Boolean updateJourneyGalleryImage(JourneyGalleryImagePO galleryImagePO);

    Boolean updateMjShowcaseLog(MjShowcaseLogPO mjShowcaseLogPO);

    Boolean updateGalleryImage(JourneyGalleryImagePO imagePO);

    List<JourneySessionPO> selectByCondition(Long userId, Integer offset, Integer number);

    List<JourneyTaskPO> selectTaskByCondition(Long userId, Long sessionId, Integer offset, Integer number);

    JourneyMemberPO selectMemberByUserId(Long userId);

    JourneyGalleryImagePO selectGalleryImageById(Long id);

    List<JourneyGalleryImagePO> selectGalleryImageByCondition(List<Long> idList, PromptSortedType sortedType,PromptStatus status, Integer offset, Integer number);

    MjShowcaseLogPO selectMjImageLogByImageId(String imageId);

    List<MjShowcaseLogPO> selectUnStoreImageLog(Integer number);

    String addShortCode(String url);

    String selectRawUrlByCode(String code);

    Boolean errorLog(Long taskId, String log);
}
