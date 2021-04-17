package com.example.powernine.deck;

import com.example.powernine.user.User;
import com.example.powernine.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class DeckController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DeckRepository deckRepository;

    @GetMapping("/decks")
    List<Deck> getDecks(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return user.getDecks();
    }

    @PostMapping("/decks")
    Deck addDeck(@RequestBody Deck deck, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        user.getDecks().add(deck);
        return deckRepository.save(deck);
    }

    @GetMapping("/decks/id/{id}")
    Deck getDeckByID(@PathVariable Long id, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return user.getDeckByID(id);
    }

    @GetMapping("/decks/name/{name}")
    Deck getDeckByName(@PathVariable String name, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return user.getDeckByName(name);
    }

}
