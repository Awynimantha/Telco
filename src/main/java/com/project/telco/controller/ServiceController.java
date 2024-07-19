package com.project.telco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.telco.model.User;
import com.project.telco.repository.UserRepository;


@Controller
@RequestMapping("/api")
//Maintain variable in the session
@SessionAttributes("user")
public class ServiceController {
    private UserRepository userRepository;

    // @ModelAttribute(name = "user")
    // public User get() {
    //     return new User();
    // }


    public ServiceController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   @RequestMapping(value="/users", method=RequestMethod.GET)
   public void getUsers(Model model) {
       Iterable<User> user = userRepository.findAll();
       model.addAttribute("user", user);
       System.out.println(model);
        System.out.println(user );
   }

   //Model is maintained throughout the session
   @RequestMapping(value = "/model", method=RequestMethod.GET)
   public void getModel(Model model) {
        System.out.println(model);
   }
   



}
