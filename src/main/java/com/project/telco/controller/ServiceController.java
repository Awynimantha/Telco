package com.project.telco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.telco.model.User;
import com.project.telco.repository.JdbcUserRepository;
import com.project.telco.repository.UserRepository;

@Controller
@RequestMapping("/api")
public class ServiceController {
    private UserRepository userRepository;

    
    public ServiceController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   @RequestMapping(value="/users", method=RequestMethod.GET)
   public void getUsers(Model model) {
        Iterable<User> users = userRepository.findAll();
        System.out.println(users);
   }



}
