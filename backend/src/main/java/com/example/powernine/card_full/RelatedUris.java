package com.example.powernine.card_full;

public class RelatedUris {
    private String gatherer;
    private String tcgplayer_infinite_articles;
    private String tcgplayer_infinite_decks;
    private String edhrec;
    private String mtgtop8;

    public RelatedUris(String gatherer, String tcgplayer_infinite_articles, String tcgplayer_infinite_decks, String edhrec, String mtgtop8) {
        this.gatherer = gatherer;
        this.tcgplayer_infinite_articles = tcgplayer_infinite_articles;
        this.tcgplayer_infinite_decks = tcgplayer_infinite_decks;
        this.edhrec = edhrec;
        this.mtgtop8 = mtgtop8;
    }

    public String getGatherer() {
        return gatherer;
    }

    public void setGatherer(String gatherer) {
        this.gatherer = gatherer;
    }

    public String getTcgplayer_infinite_articles() {
        return tcgplayer_infinite_articles;
    }

    public void setTcgplayer_infinite_articles(String tcgplayer_infinite_articles) {
        this.tcgplayer_infinite_articles = tcgplayer_infinite_articles;
    }

    public String getTcgplayer_infinite_decks() {
        return tcgplayer_infinite_decks;
    }

    public void setTcgplayer_infinite_decks(String tcgplayer_infinite_decks) {
        this.tcgplayer_infinite_decks = tcgplayer_infinite_decks;
    }

    public String getEdhrec() {
        return edhrec;
    }

    public void setEdhrec(String edhrec) {
        this.edhrec = edhrec;
    }

    public String getMtgtop8() {
        return mtgtop8;
    }

    public void setMtgtop8(String mtgtop8) {
        this.mtgtop8 = mtgtop8;
    }
}
