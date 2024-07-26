package com.project.telco.repository;


import com.project.telco.model.User;

public interface UserRepository {
   public Iterable<User> findAll (); 
   public User save(User user);
   
}
