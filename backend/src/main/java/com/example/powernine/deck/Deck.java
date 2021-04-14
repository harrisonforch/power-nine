package com.example.powernine.deck;

import com.example.powernine.card_full.Card;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "deck")
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
