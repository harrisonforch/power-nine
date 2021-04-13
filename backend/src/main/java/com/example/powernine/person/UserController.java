package com.example.powernine.person;

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
    User newEmployee(@RequestBody User newEmployee) {
        newEmployee.setPassword(User.getPasswordHash(newEmployee.getPassword()));
        return repository.save(newEmployee);
    }

    @DeleteMapping("/users/delete/{id}/{password}")
    boolean deleteUser(@PathVariable String id, @PathVariable String password) {
        Optional<User> user = this.repository.findById(id);
        if (isPresent(user, password)) {
            repository.delete(user.get());
            return true;
        }
        return false;
    }

    private static boolean isPresent(Optional<User> user, String password) {
        return user.isPresent() && user.get().comparePasswords(password);
    }

}
