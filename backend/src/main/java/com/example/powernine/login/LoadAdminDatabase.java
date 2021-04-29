package com.example.powernine.login;

import com.example.powernine.card.Card;
import com.example.powernine.deck.Deck;
import com.example.powernine.deck.DeckRepository;
import com.example.powernine.user.User;
import com.example.powernine.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.ArrayList;

@Configuration
class LoadAdminDatabase {

    @Autowired
    private PasswordEncoder encoder;

    private static final Logger log = LoggerFactory.getLogger(LoadAdminDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, DeckRepository deckRepository) {

        userRepository.deleteAll();
        deckRepository.deleteAll();

        // admin:welcome1
        return args -> {
            log.info("Preloading " + userRepository.save(new User("admin",
                    "$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm",
                    "Admin-fname", "Admin-lname", "Admin-email", "ROLE_ADMIN")));
            User user = createTestUser(3, 60);
            log.info("Preloading " + userRepository.save(user));
            for (Deck deck: user.getDecks())
                deckRepository.save(deck);
            log.info("Done");
        };
    }

    private User createTestUser(int numDecks, int numCardsPerDeck) {
        User user = new User("user", "password1", "Tommy", "Trojan",
                "tommyt@usc.edu", "ROLE_USER");
        ArrayList<Deck> decks = new ArrayList<>();
        user.setPassword(encoder.encode(user.getPassword()));
        for (int i = 0; i < numDecks; i++) {
            Deck deck = new Deck("deck" + i, new ArrayList<>());
            for (int j = 0; j < numCardsPerDeck; j++) {
                try {
                    deck.addCard(Card.random());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            decks.add(deck);
        }
        user.setDecks(decks);
        return user;
    }
}
