package com.aigccafe.buterin.service.impl;

import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.model.journey.JourneyGalleryImagePO;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.repository.JourneyRepository;
import com.aigccafe.buterin.repository.PromptRepository;
import com.aigccafe.buterin.service.PromptService;
import com.aigccafe.buterin.service.TaskService;
import com.aigccafe.buterin.service.TranslateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    private PromptService promptService;
    @Autowired
    private JourneyRepository journeyRepository;
    @Autowired
    private PromptRepository promptRepository;
    @Autowired
    private TranslateService translateService;

    @Override
    public void updateMjPromptTag() {
        List<JourneyGalleryImagePO> galleryImagePOS = journeyRepository.selectGalleryImageByCondition(null, PromptSortedType.VIEW, PromptStatus.ONLINE, 0, 1000);
        galleryImagePOS.stream().parallel().map(JourneyGalleryImagePO::getPrompt).forEach(prompt -> {
            List<String> segments = promptService.splitMjPrompt(prompt);
            String description = segments.get(0);
            String[] tags = description.split(",");
            for (String tag : tags) {
                if (tag.length() > 40) {
                    continue;
                }
                String cnTag = translateService.translateSentenceByBaidu(tag, "zh");
                try {
                    promptRepository.insertPromptTag(tag, cnTag);
                    Thread.sleep(100);
                } catch (Exception exp) {
                    log.info("插入记录:{},出现异常：{}", tag, exp.getMessage());
                    continue;
                }
            }
        });
    }

    @Override
    public void updateSdPromptTag() {

    }
}
