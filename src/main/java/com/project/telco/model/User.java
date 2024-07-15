package com.project.telco.model;

import lombok.Data;

@Data
public class User {
    private String id;
    public User(String id, String phonenumber, String name, int age) {
        this.id = id;
        this.phonenumber = phonenumber;
        this.name = name;
        this.age = age;
    }
    private String phonenumber;
    private String name;
    private int age;

}
