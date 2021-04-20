package com.example.powernine.deck;

import com.example.powernine.card.Card;
import com.example.powernine.deck.utils.DeckNotFoundException;
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
        if (!user.getDecks().contains(deck))
            user.getDecks().add(deck);
        userRepository.save(user);
        return deckRepository.save(deck);
    }

//    @GetMapping("/decks/id/{id}")
//    Deck getDeckByID(@PathVariable Long id, Principal principal) {
//        User user = userRepository.findByUsername(principal.getName());
//        return user.getDeckByID(id);
//    }

    @GetMapping("/decks/{name}")
    Deck getDeckByName(@PathVariable String name, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return user.getDeckByName(name);
    }

    @DeleteMapping("/decks/{name}")
    void deleteDeck(@PathVariable String name, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Deck deck = user.getDeckByName(name);
        user.getDecks().remove(deck);
        deckRepository.delete(deck);
        userRepository.save(user);
    }

    @PutMapping("/decks/{name}")
    Card addCardToDeck(@RequestBody Card card, @PathVariable String name, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Deck deck = user.getDeckByName(name);
        deck.addCard(card);
        userRepository.save(user);
        deckRepository.save(deck);
        return card;
    }

    @PutMapping("/decks/delete-card/{name}")
    void removeCardFromDeck(@RequestBody Card card, @PathVariable String name, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Deck deck = user.getDeckByName(name);
        deck.removeCard(card);
        userRepository.save(user);
        deckRepository.save(deck);
    }

}
