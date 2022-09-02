package com.example.demo.Service;


import com.example.demo.Model.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username,String password,String email,String number);
}