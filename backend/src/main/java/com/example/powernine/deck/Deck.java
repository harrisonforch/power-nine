package com.example.powernine.deck;

import com.example.powernine.card.Card;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

// TODO
public class Deck {
    @Id
    private Long UID;
    private String deckName;
    private ArrayList<Card> cards;

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
}
