package com.project.telco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


import com.project.telco.config.ConfigProperties;


@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
public class TelcoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TelcoApplication.class, args);
    }
}
