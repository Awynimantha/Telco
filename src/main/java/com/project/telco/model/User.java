package com.project.telco.model;

import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class User{
    private long userId;
    private String phonenumber;
    private String name;
    private int age;

   

}
