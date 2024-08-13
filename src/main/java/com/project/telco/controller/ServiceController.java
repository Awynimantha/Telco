package com.project.telco.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.project.telco.config.ConfigProperties;
import com.project.telco.model.Client;
import com.project.telco.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;





@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
//Maintain variable in the session


public class ServiceController {

    private ConfigProperties configProperties;
    private UserRepository userRepository;

    //make sure Client is in the session
    @ModelAttribute(name = "Client")
    public Client get() {
        Client newUser = new Client();
        return newUser;
    }

    public ServiceController(UserRepository userRepository, ConfigProperties configProperties){
        this.userRepository = userRepository;
        this.configProperties = configProperties;
    }

   @RequestMapping(value="/users", method=RequestMethod.GET)
   public Iterable<Client> getUsers() {
        return  userRepository.findAll();
   }

   @RequestMapping(value = "/users/{id}", method=RequestMethod.GET)
   public Optional<Client> requestMethodName(@PathVariable Long id) {
       return userRepository.findById(id);
   }
   

   @RequestMapping(value  ="/addUser", method=RequestMethod.POST)
   public Client setUser(@RequestBody Client Client, Errors errors) {
        if(errors.hasErrors()) {
            System.out.println("failed");
        }

        return userRepository.save(Client);   }
   
   //Model is maintained throughout the session
   @RequestMapping(value = "/model", method=RequestMethod.GET)
   public void getModel(Model model) {
        System.out.println(model);
   }

   @RequestMapping(value = "/test", method=RequestMethod.GET)
   public void test() {
        ConfigProperties configProperties = new ConfigProperties();
        System.out.print("-----------+++------ "+configProperties.getTestData1());
    
   }
   
   



}
