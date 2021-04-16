package com.example.powernine.document.card;

public class PurchaseUris {
    private String tcgplayer;
    private String cardmarker;
    private String cardhoarder;

    public PurchaseUris(String tcgplayer, String cardmarker, String cardhoarder) {
        this.tcgplayer = tcgplayer;
        this.cardmarker = cardmarker;
        this.cardhoarder = cardhoarder;
    }

    public String getTcgplayer() {
        return tcgplayer;
    }

    public void setTcgplayer(String tcgplayer) {
        this.tcgplayer = tcgplayer;
    }

    public String getCardmarker() {
        return cardmarker;
    }

    public void setCardmarker(String cardmarker) {
        this.cardmarker = cardmarker;
    }

    public String getCardhoarder() {
        return cardhoarder;
    }

    public void setCardhoarder(String cardhoarder) {
        this.cardhoarder = cardhoarder;
    }
}