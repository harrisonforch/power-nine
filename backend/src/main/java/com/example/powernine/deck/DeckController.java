package com.example.powernine.deck;

import com.example.powernine.user.User;
import com.example.powernine.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class DeckController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/decks")
    List<Deck> getDecks(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if (user != null) {
            return user.getDecks();
        }
        return new ArrayList<>();
    }

}
