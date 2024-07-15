package com.project.telco.repository;

import com.project.telco.model.User;

public interface UserRepository {
    Iterable<User> findAll();       
}
