package com.aigccafe.buterin.common.util;

import io.github.furstenheim.CopyDown;

public class ConvertorUtil {


    public static String convertHtmlToMarkdown(String html) {
        CopyDown converter = new CopyDown();
        return converter.convert(html);
    }
}
