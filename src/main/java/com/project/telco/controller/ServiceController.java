package com.project.telco.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.project.telco.config.ConfigProperties;
import com.project.telco.model.Client;
import com.project.telco.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/api")
//Maintain variable in the session
@SessionAttributes("Client")

public class ServiceController {

    public String string;
    private UserRepository userRepository;
    
    //make sure Client is in the session
    @ModelAttribute(name = "Client")
    public Client get() {
        Client newUser = new Client();
        return newUser;
    }

    public ServiceController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   @RequestMapping(value="/users", method=RequestMethod.GET)
   public Iterable<Client> getUsers(Model model) {
       Iterable<Client> Client = userRepository.findAll();
       //model.addAttribute("Client", Client);
       System.out.println(model);
        System.out.println(Client );
        return Client;
   }

   @RequestMapping(value  ="/addUser", method=RequestMethod.POST)
   public void setUser(@RequestBody Client Client, Errors errors, SessionStatus sessionStatus) {
        System.out.println(Client);
        if(errors.hasErrors()) {
            System.out.println("failed");
        }

        userRepository.save(Client);
        sessionStatus.setComplete();
   }
   
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
