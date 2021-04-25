package com.example.powernine.document;

import com.example.powernine.card.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Cards")
public class CardController {
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(path = "/All")
    public List<Card> getAll(){
        return cardService.getCards();
    }
    @GetMapping(path = "/{id}")
    public Card getCardById(@PathVariable("id") String id){

        return cardService.findCardByID(id);

    }

    @GetMapping(path = "/cmc/{cmc}")
    public List<Card> getCardById(@PathVariable("cmc") int id){

        return cardService.findCardByCmc(id);

    }

    @PostMapping(path = "/search")
    public List<Card> searchFunction(Search search){
        return cardService.search(search);

    }
}
