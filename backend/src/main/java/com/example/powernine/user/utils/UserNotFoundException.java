package com.example.powernine.user.utils;

class UserNotFoundException extends RuntimeException {
    UserNotFoundException(Long id) {
        super("Could not find user id \n" + id);
    }
}
