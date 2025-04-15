package com.aigccafe.buterin.api.controller;

import com.aigccafe.buterin.common.enumerate.ModelType;
import com.aigccafe.buterin.common.enumerate.PromptType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.crawl.ModelListRequest;
import com.aigccafe.buterin.common.util.ConvertorUtil;
import com.aigccafe.buterin.service.CrawlService;
import com.aigccafe.buterin.service.CrawlTaskService;
import com.aigccafe.buterin.service.ModelService;
import com.aigccafe.buterin.service.TranslateService;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Slf4j
public class TestController {

    @Value("${spring.profiles.active}")
    private String env;
    @Autowired
    private CrawlService crawlService;
    @Autowired
    private CrawlTaskService crawlTaskService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private TranslateService translateService;

    @GetMapping("/hello")
    public String Hello(@RequestParam(defaultValue = "") String image) {
        String res = translateService.translateSentenceByBaidu("hello", "zh");
        return res;
    }

    @GetMapping("/list")
    public String testTask(@RequestParam(name = "type") ModelType modelType,
                           @RequestParam(name = "batch") Integer batch,
                           @RequestParam(name = "batchNum") Integer batchNum,
                           @RequestParam(name = "cursor", required = false) Long cursor) {
        try {
            crawlTaskService.updateModelList(modelType, batch, batchNum, cursor);
            return "执行完毕！";
        } catch (Exception exception) {
            return "执行失败";
        }
    }

    @GetMapping("/detail")
    public String testDetail(@RequestParam(name = "type") ModelType modelType,
                             @RequestParam(name = "number") Integer number) {
        try {
            crawlTaskService.updateModelDetail(modelType, number);
            return "执行完毕！";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "执行失败";
        }
    }

    @GetMapping("/image")
    public String testVersionImage(@RequestParam(name = "number") Integer number) {
        try {
            log.info("开始执行");
            crawlTaskService.updateModelVersionImage(number);
            return "执行完毕！";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "执行失败";
        }
    }

    @GetMapping("/merge")
    public String modelMerge(@RequestParam(name = "type") ModelType modelType,
                             @RequestParam(name = "number") Integer number) {
        try {
            log.info("开始执行");
            crawlTaskService.mergeModelInfo(modelType, number);
            return "执行完毕！";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "执行失败";
        }
    }

    @GetMapping("/translate")
    public BaseResponse translate() {
        try {
            log.info("开始执行");
            return BaseResponse.success(translateService.translateModelContent(200));
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseResponse.fail(exception.getMessage());
        }
    }

    @GetMapping("/article")
    public BaseResponse article(@RequestParam(value = "url") String url) {
        try {
            log.info("开始执行");
            crawlTaskService.updateOuterArticle(url);
            return BaseResponse.success(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseResponse.fail(exception.getMessage());
        }
    }

    @GetMapping("/showcase")
    public BaseResponse updateMjShowCaseImage(@RequestParam(value = "startPage") Integer page,
                                              @RequestParam(value = "batch") Integer batch,
                                              @RequestParam(value = "tab") String tab) {
        try {
            log.info("开始执行");
            crawlTaskService.updateGalleryImageLog(page, batch, tab);
            return BaseResponse.success(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseResponse.fail(exception.getMessage());
        }
    }

    @GetMapping("/journey/image")
    public BaseResponse updateMjShowCaseImage(@RequestParam(value = "number") Integer number) {
        try {
            log.info("开始执行");
            crawlTaskService.updateGalleryImage(number);
            return BaseResponse.success(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseResponse.fail(exception.getMessage());
        }
    }

    @GetMapping("/stable/image/transfer")
    public BaseResponse transferAll(@RequestParam(value = "batchNum") Integer batchNumber) {
        try {
            log.info("开始执行");
            crawlTaskService.transferStableGalleryImage(batchNumber);
            return BaseResponse.success(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseResponse.fail(exception.getMessage());
        }
    }

    @GetMapping("/basemodel/revise")
    public BaseResponse reviseBaseModel(@RequestParam(value = "batchNum") Integer batchNumber) {
        try {
            log.info("开始执行");
            crawlTaskService.updateAllBaseModel(batchNumber);
            return BaseResponse.success(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseResponse.fail(exception.getMessage());
        }
    }

    @GetMapping("/prompt/translate")
    public BaseResponse promptTranslate(@RequestParam(value = "type") PromptType type) {
        try {
            log.info("开始执行");
            crawlTaskService.updatePromptTranslate(type);
            return BaseResponse.success(true);
        } catch (Exception exception) {
            exception.printStackTrace();
            return BaseResponse.fail(exception.getMessage());
        }
    }
}
