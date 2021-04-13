package com.example.powernine.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newEmployee(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping("/users")
    void deleteUser(@RequestBody User user) {
        repository.delete(user);
    }

    private static boolean isPresent(Optional<User> user, String password) {
        return user.isPresent() && user.get().comparePasswords(password);
    }

}
