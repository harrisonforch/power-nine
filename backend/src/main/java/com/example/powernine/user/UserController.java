package com.example.powernine.user;

import com.example.powernine.user.utils.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private PasswordEncoder encoder;

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
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @DeleteMapping("/users")
    void deleteUser(@RequestBody User user) {
        repository.delete(user);
    }

}
