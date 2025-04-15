package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.ModelType;
import com.aigccafe.buterin.common.enumerate.PromptType;

public interface CrawlTaskService {
    void updateModelList(ModelType modelType, Integer batch, Integer batchNum, Long cursor);

    void updateModelDetail(ModelType modelType, Integer number);

    void updateModelVersionImage(Integer number);

    void updatePostedImage();

    void mergeModelInfo(ModelType modelType, Integer number);

    void updateOuterArticle(String url);

    void updateGalleryImageLog(Integer page, Integer batch, String tab);

    void updateGalleryImage(Integer number);

    void transferStableGalleryImage(Integer batchNum);

    void updateAllBaseModel(Integer batchNum);

    void updatePromptTranslate(PromptType type);
}
