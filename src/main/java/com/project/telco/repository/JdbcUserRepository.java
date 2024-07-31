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

import com.project.telco.model.Client;

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
    public Iterable<Client> findAll() {
        return jdbcTemplate.query(
        "select id, name, age, phonenumber from \"Client\"", this::mapRowToUser);
    }

    @Override
    public Client save(Client Client) {
        System.out.println("Executing the function");
        PreparedStatementCreatorFactory pscf = 
            new PreparedStatementCreatorFactory(
                "insert into \"Client\" " 
                + "(name, phonenumber, age) values(?, ?, ? )", 
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR
            );
        pscf.setReturnGeneratedKeys(true);
        
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
            Arrays.asList(
                Client.getName(),
                Client.getPhonenumber(),
                Client.getAge()
            )
        );

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc,keyHolder);
        long userId = keyHolder.getKey().longValue();
        Client.setUserId(userId);
        return Client;
    }
    //commment
    

    private Client mapRowToUser(ResultSet row, int rowNum) 
        throws SQLException {
            String phoneNumber = row.getString("phonenumber");
            String name = row.getString("name");
            int age = row.getInt("age");

            //initializing
            Client Client = new Client(phoneNumber, name, age);
            return Client;
            
    }

    @Override
    public <S extends Client> Iterable<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public Optional<Client> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existsById'");
    }

    @Override
    public Iterable<Client> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public void delete(Client entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
    }

    @Override
    public void deleteAll(Iterable<? extends Client> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

 
}
