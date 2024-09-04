package com.project.telco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.telco.model.Client;
import com.project.telco.repository.UserRepository;
import com.project.telco.service.JmsUserMessagingService;


@RestController
@RequestMapping(path = "/api/message", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class MessageController {
    private UserRepository userRepository;
    private JmsUserMessagingService jmsUserMessagingService;

    public MessageController(UserRepository userRepository, JmsUserMessagingService jmsUserMessagingService) {
        this.userRepository = userRepository;
        this.jmsUserMessagingService = jmsUserMessagingService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Client sendClient(Client client) {
        jmsUserMessagingService.sendClientObj(client);
        return client;
    }
        
    
    
}
