package com.project.telco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.project.telco.model.User;
import com.project.telco.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/api")
//Maintain variable in the session
@SessionAttributes("user")
public class ServiceController {
    private UserRepository userRepository;
    //make sure user is in the session
    @ModelAttribute(name = "user")
    public User get() {
        User newUser = new User();
        newUser.setAge(34);
        return newUser;
    }


    public ServiceController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   @RequestMapping(value="/users", method=RequestMethod.GET)
   public void getUsers(Model model) {
       Iterable<User> user = userRepository.findAll();
       //model.addAttribute("user", user);
       System.out.println(model);
        System.out.println(user );
   }

   @RequestMapping(value  ="/addUser", method=RequestMethod.POST)
   public void setUser(@RequestBody User user, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()) {
            System.out.println("failed");
        }

        System.out.println(user);
      //userRepository.save(user);
        //sessionStatus.setComplete();
   }
   
   //Model is maintained throughout the session
   @RequestMapping(value = "/model", method=RequestMethod.GET)
   public void getModel(Model model) {
        System.out.println(model);
   }
   



}
