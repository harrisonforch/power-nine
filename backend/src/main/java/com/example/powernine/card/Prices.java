package com.example.powernine.card;

public class Prices {
    private String usd;
    private String usd_foil;
    private String eur;
    private String eur_foil;
    private String tix;

    public Prices(String usd, String usd_foil, String eur, String eur_foil, String tix) {
        this.usd = usd;
        this.usd_foil = usd_foil;
        this.eur = eur;
        this.eur_foil = eur_foil;
        this.tix = tix;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getUsd_foil() {
        return usd_foil;
    }

    public void setUsd_foil(String usd_foil) {
        this.usd_foil = usd_foil;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    public String getEur_foil() {
        return eur_foil;
    }

    public void setEur_foil(String eur_foil) {
        this.eur_foil = eur_foil;
    }

    public String getTix() {
        return tix;
    }

    public void setTix(String tix) {
        this.tix = tix;
    }
}
