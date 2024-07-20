package com.project.telco.repository;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;

import com.project.telco.model.User;

public interface UserRepository {
    Iterable<User> findAll();       
    User save(User user);
}
