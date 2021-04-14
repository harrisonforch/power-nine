package com.example.powernine.card;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "card")
public class Card {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }
}
