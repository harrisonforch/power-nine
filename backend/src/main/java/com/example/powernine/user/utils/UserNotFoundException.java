package com.example.powernine.user.utils;

import com.example.powernine.user.User;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(User user) {
        super("Could not find user " + user);
    }
}
