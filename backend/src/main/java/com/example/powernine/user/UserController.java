package com.example.powernine.user;

import com.example.powernine.user.utils.UserExistsException;
import com.example.powernine.user.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepository repository;

    @PostMapping("/users/login")
    User login(@RequestBody User user) {
        User potentialUser = repository.findByUsername(user.getUsername());
        if (potentialUser != null) {
            if (encoder.matches(user.getPassword(), potentialUser.getPassword())) {
                return potentialUser;
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser == null) {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRole("ROLE_USER");
            return repository.save(user);
        }
        throw new UserExistsException(user.getUsername());
    }

    @DeleteMapping("/users")
    void deleteUser(@RequestBody User user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser != null) {
            if (encoder.matches(user.getPassword(), existingUser.getPassword())) {
                repository.delete(user);
                return;
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

    @PutMapping("/users")
    User updateUser(@RequestBody UpdatedUser user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser != null) {
            if (encoder.matches(user.getPassword(), existingUser.getPassword())) {
                repository.delete(user);
                user.setPassword(encoder.encode(user.getNewPassword()));
                user.setRole("ROLE_USER");
                return repository.save(user);
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

}
