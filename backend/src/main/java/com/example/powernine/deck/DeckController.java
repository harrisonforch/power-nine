package com.example.powernine.deck;

import com.example.powernine.card.Card;
import com.example.powernine.deck.utils.DeckNotFoundException;
import com.example.powernine.user.User;
import com.example.powernine.user.UserRepository;
import com.example.powernine.user.utils.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    List<Deck> getDecks() {
        return deckRepository.findAll();
    }

    @PostMapping("/decks")
    Deck addDeck(@RequestBody Deck deck, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        if (!user.getDecks().contains(deck))
            user.getDecks().add(deck);
        userRepository.save(user);
        return deckRepository.save(deck);
    }

    @GetMapping("/decks/{name}")
    Deck getDeckByName(@PathVariable String name) {
        Deck deck = deckRepository.findByDeckName(name);
        if (deck == null)
            throw new DeckNotFoundException("Deck name not found");
        return deck;
    }

    @GetMapping("/decks/{name}/{username}")
    Deck getUserDeckByName(@PathVariable String name, @PathVariable String username) {
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(username);
        for (Deck deck: user.getDecks()) {
            if (deck.getDeckName().equals(name))
                return deck;
        }
        throw new DeckNotFoundException("Deck name for user not found");
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

    @DeleteMapping("/decks/delete-card/{name}")
    void removeCardFromDeck(@RequestBody Card card, @PathVariable String name, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Deck deck = user.getDeckByName(name);
        deck.removeCard(card);
        userRepository.save(user);
        deckRepository.save(deck);
    }

}
