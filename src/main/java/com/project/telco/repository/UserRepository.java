package com.project.telco.repository;


import org.springframework.data.repository.CrudRepository;

import com.project.telco.model.Client;

public interface UserRepository extends CrudRepository<Client, Long>{
  
   
}
