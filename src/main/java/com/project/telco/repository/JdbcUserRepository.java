package com.project.telco.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.telco.model.Client;

@Service
public class JdbcUserRepository  {
    @Autowired
    private UserRepository userRepository;

    public Iterable<Client> getUsers() {
        return userRepository.findAll();
    }
   

   

 
}
