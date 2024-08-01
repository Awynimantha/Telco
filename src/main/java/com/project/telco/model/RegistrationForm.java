package com.project.telco.model;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
    private String name;
    private String phonenumber;
    private int age;
    private String password;
    
    public Client toUser(PasswordEncoder passwordEncoder) {
        return new Client(
            phonenumber, name, age, passwordEncoder.encode(password)
        );
    }
}
