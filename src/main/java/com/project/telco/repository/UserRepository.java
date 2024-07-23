package com.project.telco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.telco.model.User;

public interface UserRepository {
   public Iterable<User> findAll (); 
   public User save(User user);
   
}
