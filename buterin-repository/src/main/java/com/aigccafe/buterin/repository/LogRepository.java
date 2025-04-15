package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.model.log.WebLogBO;

public interface LogRepository {
    int insert(WebLogBO webLogBO);
}
