package com.example.powernine.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
