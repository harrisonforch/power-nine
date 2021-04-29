package com.example.powernine.user.utils;

import com.example.powernine.deck.Deck;
import com.example.powernine.deck.DeckRatings;
import com.example.powernine.deck.DeckRatingsRepository;
import com.example.powernine.deck.DeckRepository;
import com.example.powernine.deck.utils.DeckNotFoundException;
import com.example.powernine.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserWrapper {
    private final String username;
    private final String password;
    private final List<Deck> decks;
    private final ArrayList<Float> deckRatings;

    private static final Logger logger = LoggerFactory.getLogger(UserWrapper.class);

    public UserWrapper(User user, DeckRatingsRepository deckRatingsRepository) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.decks = user.getDecks();
        this.deckRatings = new ArrayList<>();
        getAvgDeckRatings(user, deckRatingsRepository);
    }

    private void getAvgDeckRatings(User user, DeckRatingsRepository deckRatingsRepository) {
        for (Deck deck: user.getDecks()) {
            float totalRating = 0;
            List<DeckRatings> ratings = deckRatingsRepository.findAllByDeckUID(deck.getId());
            int i = 0;
            for (DeckRatings deckRatings: ratings) {
                if (deckRatings.getRating() != null) {
                    i += 1;
                    totalRating += deckRatings.getRating();
                }
            }
            if (i != 0)
                this.deckRatings.add(totalRating / i);
            else
                this.deckRatings.add(Float.parseFloat("0"));
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public ArrayList<Float> getDeckRatings() {
        return deckRatings;
    }
}
