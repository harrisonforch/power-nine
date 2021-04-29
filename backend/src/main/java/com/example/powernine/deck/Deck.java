package com.example.powernine.deck;

import com.example.powernine.card.Card;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "deck")
public class Deck {
    private static long count = 0L;
    @Id
    @Indexed(unique = true)
    private Long UID;
    private String deckName;
    private ArrayList<Card> cards;
    private Long userUID;

    public Deck() {
        this.UID = count;
        count += 1;
    }

    public Deck(String deckName, ArrayList<Card> cards) {
        this.UID = count;
        count += 1;
        this.deckName = deckName;
        this.cards = cards;
    }

    public Deck(String deckName, ArrayList<Card> cards, Long userUID) {
        this.UID = count;
        count += 1;
        this.deckName = deckName;
        this.cards = cards;
        this.userUID = userUID;
    }

    public Long getId() {
        return UID;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Deck) {
            return getDeckName().equals(((Deck) other).getDeckName());
        }
        return false;
    }

    public Long getUserUID() {
        return userUID;
    }

    public void setUserUID(Long userUID) {
        this.userUID = userUID;
    }
}
