package com.project.telco.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.project.telco.model.Client;
import com.project.telco.repository.UserRepository;

@Configuration
public class MainConfigs {
    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args-> {
            Client client = new Client("034830","Holden McCrouch",12,"password");
            userRepository.save(client);
        };
    }


}
