package com.example.powernine.person;

import com.example.powernine.deck.Deck;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class User {

    @Id
    private String id;

    private String userId;
    private String passwordHash;
    private ArrayList<Deck> decks;

}
