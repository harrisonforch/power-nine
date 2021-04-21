package com.example.powernine.document;

import java.util.Arrays;


public class Search {
    private String name;
    private String[] color;
    private String matching;
    private String statMatching;
    private Integer stat;
    private String statType;
    private String[] rarity;

    public Search(String name, String[] color, String matching, String statMatching, Integer stat, String statType, String[] rarity) {
        this.name = name;
        this.color = color;
        this.matching = matching;
        this.statMatching = statMatching;
        this.stat = stat;
        this.statType = statType;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public String getMatching() {
        return matching;
    }

    public void setMatching(String matching) {
        this.matching = matching;
    }

    public String getStatMatching() {
        return statMatching;
    }

    public void setStatMatching(String statMatching) {
        this.statMatching = statMatching;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }

    public String[] getRarity() {
        return rarity;
    }

    public void setRarity(String[] rarity) {
        this.rarity = rarity;
    }

    @Override
    public String toString() {
        return "Search{" +
                "name='" + name + '\'' +
                ", color=" + Arrays.toString(color) +
                ", matching='" + matching + '\'' +
                ", statMatching='" + statMatching + '\'' +
                ", stat=" + stat +
                ", statType='" + statType + '\'' +
                ", Rarity='" + rarity + '\'' +
                '}';
    }
}
