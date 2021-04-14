package com.example.powernine.deck;

public class DeckNotFoundException extends RuntimeException {
    public DeckNotFoundException(long id) {
        super(String.format("Could not locate deck id %d", id));
    }

    public DeckNotFoundException(String name) {
        super(String.format("Could not locate deck name %s", name));
    }
}
