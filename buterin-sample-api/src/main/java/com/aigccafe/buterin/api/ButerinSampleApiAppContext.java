package com.aigccafe.buterin.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication(scanBasePackages = {"com.aigccafe.buterin"})
@EnableScheduling
public class ButerinSampleApiAppContext {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ButerinSampleApiAppContext.class);
        app.run(args);
    }
}
