package com.aigccafe.buterin.common.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RetryTask {
    public static void retry(int maxRetries, Runnable action) throws Exception {
        int numAttempts = 0;
        String msg = "";
        while (numAttempts < maxRetries) {
            try {
                action.run();
                return;
            } catch (Exception e) {
                numAttempts++;
                if (numAttempts < maxRetries) {
                    log.info("Attempt " + numAttempts + " failed. Retrying...");
                }
                msg = e.getMessage();
            }
        }
        throw new RuntimeException("Failed after " + maxRetries + " attempts, msg:" + msg);
    }
}
