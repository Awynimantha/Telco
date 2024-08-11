package com.project.telco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.project.telco.config.ConfigProperties;


@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties(ConfigProperties.class)
public class TelcoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TelcoApplication.class, args);
    }
}
