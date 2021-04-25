package com.example.powernine.document;

import com.example.powernine.document.Search;
import com.example.powernine.document.CardRepository;
import com.example.powernine.card.Card;
import com.example.powernine.search.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private searchRepository searchRepository;
    public List<Card> getCards(){


        return cardRepository.findAll();
    }

    public List<Card> findCardByCmc(int cmc){



        return  cardRepository.findBycmcBetween(cmc-1,cmc+1);
    }

    public Card findCardByID(String id){
        Query g = new Query();
        
        return cardRepository.findById(id).get();
    }

    public List<Card> search(Search search){
        return searchRepository.getSearch(search);
    }

}
