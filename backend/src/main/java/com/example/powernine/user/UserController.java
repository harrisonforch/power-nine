package com.example.powernine.user;

import com.example.powernine.user.utils.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    List<User> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser == null) {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRole("ROLE_USER");
            return repository.save(user);
        } else {
            throw new UserExistsException(user.getUsername());
        }
    }

    @DeleteMapping("/users")
    void deleteUser(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser != null) {
            repository.deleteById(user.getUID());
        } else {
            throw new UsernameNotFoundException(user.getUsername());
        }
    }

    @PutMapping("/users/{id}")
    User updateUser(@RequestBody User user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser != null) {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRole("ROLE_USER");
            return repository.save(user);
        } else {
            throw new UserExistsException(user.getUsername());
        }
    }

}
