package com.project.telco.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.telco.model.User;

@Repository
public class JdbcIngredientRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public  Iterable<User> findAll() {
        return jdbcTemplate.query(
            "select id, name, phonenumber, age  from user", this::mapRowToUser
        );
    }
    
    private User mapRowToUser(ResultSet row, int rowNum) 
        throws SQLException {
            return new User(
                row.getString("id"), 
                row.getString("phonenumber"), 
                row.getString("name"),
                row.getInt("age")

            );
        }
}
