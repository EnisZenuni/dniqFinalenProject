package com.example.demo.Model.Exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Incorrect username or password. Please try again");
    }
}
