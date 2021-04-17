package com.example.powernine.deck;

import com.example.powernine.card.Card;
import com.example.powernine.deck.utils.DeckNotFoundException;
import com.example.powernine.user.User;
import com.example.powernine.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/decks")
    void deleteDeck(@RequestBody Deck deck, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        user.getDecks().remove(deck);
        deckRepository.delete(deck);
    }

    @PutMapping("/decks/card/{id}")
    Card addCardToDeck(@RequestBody Card card, @PathVariable Long id, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        Optional<Deck> deck = deckRepository.findById(id);
        if (deck.isPresent()) {
            deck.get().addCard(card);
            user.getDeckByID(id).addCard(card);
            return card;
        }
        throw new DeckNotFoundException(id);
    }

}
