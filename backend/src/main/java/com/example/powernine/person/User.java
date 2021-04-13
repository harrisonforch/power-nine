package com.example.powernine.person;

import com.example.powernine.deck.Deck;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;

public class User {

    @Id
    private String id;
    private String userId;
    private String passwordHash;
    private HashMap<Integer, Deck> deckMapByUID;
    private HashMap<String, Deck> deckMapByName;

    public User() {
        deckMapByUID = new HashMap<>();
        deckMapByName = new HashMap<>();
    }

    /**
     * Get Deck from stored hashmap, which is mapped based on
     * @param id ID associated with Deck object (e.g. Deck UID)
     * @return Deck if present or null if not present
     */
    public Deck getDeckByID(int id) {
        if (deckMapByUID.containsKey(id))
            return deckMapByUID.get(id);
        return null;
    }

    public Deck getDeckByName(String name) {
        if (deckMapByName.containsKey(id))
            return deckMapByName.get(id);
        return null;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
