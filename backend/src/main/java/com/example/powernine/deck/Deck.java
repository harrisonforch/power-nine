package com.example.powernine.deck;

import com.example.powernine.card.Card;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "deck")
public class Deck {
    @Id
    private long UID;
    private String deckName;
    private ArrayList<Card> deckList;

    public Long getId() {
        return UID;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }
}
