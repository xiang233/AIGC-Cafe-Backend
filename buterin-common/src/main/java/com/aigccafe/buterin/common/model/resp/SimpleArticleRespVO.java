package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class SimpleArticleRespVO {

    private Long id;

    private String title;

    List<SimpleArticleRespVO> childArticleList;
}
