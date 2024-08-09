package com.project.telco.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="props")
@Component
@Data
public class ConfigProperties {
    private String testData1;
    private String testData2;
    private String testData3;

    public String getTestData1() {
        return testData1;
    }

    public void setTestData1(String testData1) {
        this.testData1 = testData1;
    }

    public String getTestData2() {
        return testData2;
    }

    public void setTestData2(String testData2) {
        this.testData2 = testData2;
    }

    public String getTestData3() {
        return testData3;
    }

    public void setTestData3(String testData3) {
        this.testData3 = testData3;
    }


}
