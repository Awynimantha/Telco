package com.project.telco.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.telco.model.User;

@Repository
public class JdbcUserRepository implements UserRepository{
    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public Iterable<User> findAll() {
        return jdbcTemplate.query(
            "select id, name, phonenumber, age from \"User\"", this::mapRowToUser
        );
    }

    @Override
    public User save(User user) {
        jdbcTemplate.update("insert into  \"User\" (id, name, phonenumber, age) values(?,?,?,?)", 
            user.getId(), user.getName(), user.getPhonenumber(), user.getAge());
        return user;
    }


    private User mapRowToUser(ResultSet row, int rowNum) 
        throws SQLException {
            String id = row.getString("id");
            String phoneNumber = row.getString("phonenumber");
            String name = row.getString("name");
            int age = row.getInt("age");

            //initializing
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setPhonenumber(phoneNumber);
            user.setAge(age);
            return user;
            

        }
}
