package com.example.powernine.search;

import com.example.powernine.document.Search;
import com.example.powernine.card.Card;

import java.util.List;

public interface CardDAL {
        List<Card> getSearch(Search search);

}
