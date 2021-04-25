package com.example.powernine.document;

import com.example.powernine.card.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<Card,String> {
    List<Card> findBycmcBetween(int to, int from);
}
