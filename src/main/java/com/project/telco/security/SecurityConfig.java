package com.project.telco.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


@Configuration
@EnableJms
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> usersList = new ArrayList<>();
        usersList.add(new User(
            "User1", encoder.encode("password"),
            Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        ));
        usersList.add(new User(
            "newUser",  encoder.encode("newly"),
            Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))
        ));
        
        
        return new InMemoryUserDetailsManager(usersList);
    }
    
    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
            .anyRequest().permitAll()).csrf(AbstractHttpConfigurer::disable);;
            // ...

        return http.build();
    }


    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //    super.configure(http);

    //    if(!csrfEnabled)
    //    {
    //      http.csrf().disable();
    //    }
    // }




}
