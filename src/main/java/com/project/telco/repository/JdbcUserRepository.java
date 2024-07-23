package com.project.telco.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Optional;

import org.hibernate.sql.exec.spi.JdbcOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.telco.model.User;

@Service
public class JdbcUserRepository implements UserRepository {
    @Autowired


    private JdbcTemplate jdbcTemplate;
    private JdbcOperations jdbcOperations;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate, JdbcOperations jdbcOperations) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcOperations = jdbcOperations;

    }

    @Override
    public Iterable<User> findAll() {
        return jdbcTemplate.query(
        "select id, name, age, phonenumber from \"User\"", this::mapRowToUser);
    }

    @Override
    public User save(User user) {
        System.out.println("Executing the function");
        PreparedStatementCreatorFactory pscf = 
            new PreparedStatementCreatorFactory(
                "insert into \"User\" " 
                + "(name, phonenumber, age) values(?, ?, ? )", 
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
            );
        pscf.setReturnGeneratedKeys(true);
        
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
            Arrays.asList(
                user.getName(),
                user.getPhonenumber(),
                user.getAge()
            )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc,keyHolder);
        long userId = keyHolder.getKey().longValue();
        user.setUserId(userId);
        return user;
    }


    private User mapRowToUser(ResultSet row, int rowNum) 
        throws SQLException {
            String phoneNumber = row.getString("phonenumber");
            String name = row.getString("name");
            int age = row.getInt("age");

            //initializing
            User user = new User();
            user.setName(name);
            user.setPhonenumber(phoneNumber);
            user.setAge(age);
            return user;
            

        }

 
}
