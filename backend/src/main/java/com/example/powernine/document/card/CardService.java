package com.example.powernine.document.card;

import com.example.powernine.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    public List<Card> getCards(){


        return cardRepository.findAll();
    }

    public List<Card> findCardByCmc(int cmc){

        return  cardRepository.findBycmcBetween(cmc-1,cmc+1);
    }

    public Card findCardByID(String id){

        return cardRepository.findById(id).get();
    }

}
