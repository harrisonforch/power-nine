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
                return user;
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser == null) {
            String oldPassword = user.getPassword();
            user.setPassword(encoder.encode(oldPassword));
            user.setRole("ROLE_USER");
            repository.save(user);
            user.setPassword(oldPassword);
            return user;
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
                String preChange = user.getNewPassword();
                user.setPassword(encoder.encode(preChange));
                user.setRole("ROLE_USER");
                repository.save(user);
                user.setPassword(preChange);
                return user;
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

}
