package com.project.telco.model;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
public class User {
    @Id
    private long userId;
    private String phonenumber;
    private String name;
    private int age;

   

}
