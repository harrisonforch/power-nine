package com.example.powernine.deck;

import com.example.powernine.card.Card;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

// TODO
public class Deck {
    @Id
    private String UID;
    private String deckName;
    private ArrayList<Card> deckList;

    public String getId() {
        return UID;
    }
}
