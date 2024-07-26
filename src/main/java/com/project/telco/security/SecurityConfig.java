package com.project.telco.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();

    }

    @Bean 
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails>  usersList = new ArrayList<>();
        usersList.add(new User(
            "User1", encoder.encode("password"), 
            Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
        ));
        return (UserDetailsService) new InMemoryUserDetailsManager(usersList);
    }
    
}
