package com.example.powernine.user;

import com.example.powernine.deck.Deck;
import com.example.powernine.deck.DeckRatingsRepository;
import com.example.powernine.user.utils.UserExistsException;
import com.example.powernine.user.utils.UserNotFoundException;
import com.example.powernine.user.utils.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private DeckRatingsRepository deckRatingsRepository;

    @GetMapping("/users")
    List<User> allUsers() {
        return repository.findAll();
    }

    @PostMapping("/users/login")
    UserWrapper login(@RequestBody User user) {
        User potentialUser = repository.findByUsername(user.getUsername());
        if (potentialUser != null) {
            if (encoder.matches(user.getPassword(), potentialUser.getPassword())) {
                potentialUser.setPassword(user.getPassword());
                return new UserWrapper(potentialUser, deckRatingsRepository);
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

    @PostMapping("/users")
    UserWrapper newUser(@RequestBody User user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser == null) {
            String oldPassword = user.getPassword();
            user.setPassword(encoder.encode(oldPassword));
            user.setRole("ROLE_USER");
            repository.save(user);
            user.setPassword(oldPassword);
            return new UserWrapper(user, deckRatingsRepository);
        }
        throw new UserExistsException(user.getUsername());
    }

    @DeleteMapping("/users")
    void deleteUser(@RequestBody User user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser != null) {
            if (encoder.matches(user.getPassword(), existingUser.getPassword())) {
                repository.delete(existingUser);
                return;
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

    @PutMapping("/users")
    UserWrapper updateUser(@RequestBody UpdatedUser user) {
        User existingUser = repository.findByUsername(user.getUsername());
        if (existingUser != null) {
            if (encoder.matches(user.getPassword(), existingUser.getPassword())) {
                repository.delete(existingUser);
                user.setRole("ROLE_USER");
                for (Deck deck : existingUser.getDecks()) {
                    if (!user.getDecks().contains(deck))
                        user.addDeck(deck);
                }
                String preChange = null;
                if (user.getNewPassword() != null) {
                    preChange = user.getNewPassword();
                    user.setPassword(encoder.encode(preChange));
                } else {
                    user.setPassword(existingUser.getPassword());
                }
                if (user.getEmail() == null) {
                    user.setEmail(existingUser.getEmail());
                }
                if (user.getFirstName() == null) {
                    user.setFirstName(existingUser.getFirstName());
                }
                if (user.getLastName() == null) {
                    user.setLastName(existingUser.getLastName());
                }
                repository.save(user);
                if (preChange != null)
                    user.setPassword(preChange);
                return new UserWrapper(user, deckRatingsRepository);
            }
            throw new UserNotFoundException(user);
        }
        throw new UserNotFoundException(user);
    }

}
