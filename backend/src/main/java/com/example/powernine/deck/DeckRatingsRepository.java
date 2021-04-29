package com.example.powernine.deck;

import com.example.powernine.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeckRatingsRepository extends MongoRepository<DeckRatings, Long> {

}
