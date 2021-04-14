package com.example.powernine.user;

import com.example.powernine.deck.Deck;
import com.example.powernine.deck.DeckNotFoundException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "user")
public class User {

    @Id
    private String UID;
    private String username;
    private String password;
    @DBRef
    private ArrayList<Deck> decks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, ArrayList<Deck> decks) {
        this.username = username;
        this.password = password;
        this.decks = decks;
    }

    public String getUID() {
        return UID;
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

    public boolean comparePasswords(User other) {
        return this.password.equals(other.getPassword());
    }

    @Override
    public String toString() {
        return getUsername() + " " + getPassword();
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public Deck getDeckByID(Long id) {
        for (Deck deck: decks) {
            if (deck.getId().equals(id))
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
