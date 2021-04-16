package com.example.powernine.document.deck;

public class DeckNotFoundException extends RuntimeException{
    public DeckNotFoundException(Long id) {
        super(String.format("Unable to locate deck id %d", id));
    }

    public DeckNotFoundException(String name) {
        super(String.format("Unable to locate deck name %s", name));
    }
}