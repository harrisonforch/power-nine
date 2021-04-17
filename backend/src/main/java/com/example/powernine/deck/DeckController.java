package com.example.powernine.deck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class DeckController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private DeckRepository repository;

    @GetMapping("/decks")
    List<Deck> getDecks(Principal principal) {
        return null;
    }

}
