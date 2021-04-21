package com.example.powernine.user;

import com.example.powernine.deck.Deck;
import com.example.powernine.deck.utils.DeckNotFoundException;
import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "user")
public class User {

    private static Long count = 0L;

    @Id
    private Long UID;
    @Indexed(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    @DBRef
    private ArrayList<Deck> decks;

    public User(@NonNull String username, @NonNull String password, String firstName, String lastName, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.UID = count;
        count += 1;
        this.username = username;
        this.password = password;
        this.decks = new ArrayList<>();
        this.role = role;
    }

    public void setUID(Long uid) {
        this.UID = uid;
    }

    public Long getUID() {
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

    public void addDeck(Deck deck) {
        if (!decks.contains(deck))
            decks.add(deck);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
