package com.example.powernine.deck;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "deckratings")
public class DeckRatings {
    private static long count = 0L;
    @Id
    @Indexed(unique = true)
    private Long UID;
    private Long deckUID;
    private Integer rating;

    public DeckRatings() {
        UID = count;
        count += 1;
    }

    public DeckRatings(Long deckUID, Integer rating) {
        UID = count;
        count += 1;
        this.deckUID = deckUID;
        this.rating = rating;
    }

    public static long getCount() {
        return count;
    }

    public static void setCount(long count) {
        DeckRatings.count = count;
    }

    public Long getDeckUID() {
        return deckUID;
    }

    public void setDeckUID(Long deckUID) {
        this.deckUID = deckUID;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
