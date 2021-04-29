package com.example.powernine.deck;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeckRepository extends MongoRepository<Deck, Long> {
    Deck findByDeckName(String deckName);
}
