package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.model.crawl.ModelDetailRequest;
import com.aigccafe.buterin.common.model.crawl.ModelListRequest;
import com.aigccafe.buterin.common.model.crawl.ModelVersionImageRequest;
import com.aigccafe.buterin.common.model.cvt.CvtModelDetailPO;
import com.aigccafe.buterin.common.model.cvt.CvtModelDetailPOWithBLOBs;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.util.Pair;

public interface CrawlService {

    // ------模型采集--------
    // c站列表采集
    JSONObject crawlModelList(ModelListRequest request) throws Exception;

    Pair<Long, JSONArray> parseModelListJson(JSONObject data) throws NullPointerException;

    Long updateModelListRecord(ModelListRequest requestInfo, Pair<Long, JSONArray> data) throws RuntimeException;

    // c站详情页采集
    JSONArray crawlModelDetail(ModelDetailRequest request) throws Exception;

    int updateModelDetailRecord(JSONArray response) throws RuntimeException;

    // c站版本图片采集
    JSONObject crawlModelVersionImage(ModelVersionImageRequest request) throws Exception;

    int updateModelVersionImageRecord(Long modelId, JSONObject response) throws RuntimeException;

    // c站采集信息入库
    int modelMergedInMysql(CvtModelDetailPOWithBLOBs cvtModelDetailPO);

    //----文章采集------
    // sd art
    String crawlSdArtArticle(String url);

    // 解析html,转储图片及文件，并进行替换
    String convertToLocalHtml(String html);

    // 抽取文章信息
    JSONObject extractArticleInfo(String html);


    //-------其他
    // 将下载地址解析，返回真正的cdn下载地址
    String transferUrl(String url);

    // mj-showcase采集
    JSONArray crawlShowcaseImage(String tab, Integer page, Integer amount);

}
