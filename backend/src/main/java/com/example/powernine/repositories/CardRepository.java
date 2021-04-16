package com.example.powernine.repositories;

import com.example.powernine.document.card.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardRepository extends MongoRepository<Card,String> {
    List<Card> findBycmcBetween(int to, int from);
}
