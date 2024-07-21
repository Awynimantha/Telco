package com.project.telco.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.telco.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
 
}
