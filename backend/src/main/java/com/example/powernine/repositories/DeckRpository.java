package com.example.powernine.repositories;

import com.example.powernine.document.Deck;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeckRpository extends MongoRepository<Deck, Integer> {
}
