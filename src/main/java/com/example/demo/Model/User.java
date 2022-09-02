package com.example.demo.Model;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class User {
    String username;
    String password;
    String email;
    String number;


    public User(String username, String password, String email, String number) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.number = number;
    }
}

