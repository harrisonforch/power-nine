package com.example.powernine.user;

import com.example.powernine.deck.Deck;
import com.example.powernine.deck.DeckNotFoundException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
public class User {

    @Id
    private String UID;
    private String username;
    private String password;
    @DBRef
    List<Deck> decks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.decks = new ArrayList<>();
    }

    public User(String username, String password, List<Deck> decks) {
        this.username = username;
        this.password = password;
        this.decks = decks;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    @Override
    public String toString() {
        return getUID() + " " + getUsername() + " " + getPassword();
    }

    public Deck getDeckByID(long id) {
        for (Deck deck: decks) {
            if (deck.getId() == id)
                return deck;
        }
        throw new DeckNotFoundException(id);
    }

    public Deck getDeckByName(String name) {
        for (Deck deck: decks) {
            if (deck.getDeckName().equals(name))
                return deck;
        }
        throw new DeckNotFoundException(name);
    }
}
