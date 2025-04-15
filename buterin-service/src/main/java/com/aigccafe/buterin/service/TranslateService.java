package com.aigccafe.buterin.service;

public interface TranslateService {

    boolean translateModelContent(Integer number);

    String translateHtml(String html) throws Exception;

    String translateHtmlBySplit(String html) throws Exception;

    String translateSentenceByOpenAI(String sentence);

    String translateSentenceByNLP(String sentence);

    String translateSentenceByBaidu(String sentence, String lang);

    String detectLangByBaidu(String sentence);

    String transferImageToLocal(String imageUrl);
}
