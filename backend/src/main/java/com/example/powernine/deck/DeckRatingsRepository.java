package com.example.powernine.deck;

import com.example.powernine.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DeckRatingsRepository extends MongoRepository<DeckRatings, Long> {
    DeckRatings findByDeckUID(Long deckUID);
    List<DeckRatings> findAllByDeckUID(Long deckUID);
}
