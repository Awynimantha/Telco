package com.project.telco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.telco.repository.JdbcIngredientRepository;

@Controller
@RequestMapping("/api")
public class ServiceController {
    private ServiceController serviceController;


   @RequestMapping(value="/users", method=RequestMethod.GET)
   public String addUser(Model model) {
        JdbcIngredientRepository repo = JdbcIngredientRepository(); 
        Iterable<User> users = 
   }
}
