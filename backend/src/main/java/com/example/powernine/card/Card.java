package com.example.powernine.card;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "card")
public class Card {
    @Id
    private Long id;
    private Integer arena_id;
    private String land;
    private Integer mtgo_id;
    private Integer mtgo_foil_id;
    private ArrayList<Integer> multiverse_ids;
    private Integer tcgplayer_id;
    private Integer cardmarket_id;
    private String object;
    private Long oracle_id;
    private String prints_search_uri;
    private String rulings_url;
    private String scryfall_uri;
    private String uri;


    public static Card fromJSON(String jsonData) {
        return null;
    }
}
