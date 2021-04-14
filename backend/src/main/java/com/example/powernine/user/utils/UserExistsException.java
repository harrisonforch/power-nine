package com.example.powernine.user.utils;

public class UserExistsException extends RuntimeException{
    public UserExistsException(String username) {
        super(String.format("Username %s already exists%n", username));
    }
}
