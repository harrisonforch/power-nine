package com.example.powernine.card;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Card {
    // Core card fields
    private String id;
    private Integer arena_id;
    private String land;
    private Integer mtgo_id;
    private Integer mtgo_foil_id;
    private ArrayList<Integer> multiverse_ids;
    private Integer tcgplayer_id;
    private Integer cardmarket_id;
    private String object;
    private String oracle_id;
    private String prints_search_uri;
    private String rulings_url;
    private String scryfall_uri;
    private String uri;

    // Gameplay fields
    private ArrayList<RelatedCard> all_parts;
    private ArrayList<CardFace> card_faces;
    private Double cmc;
    private ArrayList<String> color_identity;
    private ArrayList<String> color_indicator;
    private ArrayList<String> colors;
    private Integer edhrec_rank;
    private Boolean foil;
    private String hand_modifier;
    private ArrayList<String> keywords;
    private String layout;
    private Legalities legalities;
    private String life_modifier;
    private String loyalty;
    private String mana_cost;
    private String name;
    private Boolean nonfoil;
    private String oracle_text;
    private Boolean oversized;
    private String power;
    private ArrayList<String> produced_mana;
    private Boolean reserved;
    private String toughness;
    private String type_line;

    // Print fields
    private String artist;
    private Boolean booster;
    private String border_color;
    private String card_back_id;
    private String collector_number;
    private Boolean content_warning;
    private Boolean digital;
    private String flavor_name;
    private String flavor_text;
    private ArrayList<String> frame_effects;
    private String frame;
    private Boolean full_art;
    private ArrayList<String> games;
    private Boolean highres_image;
    private String illustration_id;
    private String image_status;
    private ImageUris image_uris;
    private Prices prices;
    private String printed_name;
    private String printed_text;
    private String printed_type_line;
    private Boolean promo;
    private ArrayList<String> promo_types;
    private String rarity;
    private RelatedUris related_uris;
    private String released_at;
    private Boolean reprint;
    private String scryfall_set_uri;
    private String set_name;
    private String set_search_uri;
    private String set_type;
    private String set_uri;
    private String set;
    private Boolean story_splotlight;
    private Boolean textless;
    private Boolean variation;
    private String variation_of;
    private String watermark;

    @Override
    public boolean equals(Object other) {
        if (other instanceof Card)
            return this.id.equals(((Card) other).getId());
        return false;
    }

    public static Card fromJSON(String jsonString) throws JsonSyntaxException {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Card>(){}.getType();
        return gson.fromJson(jsonString, collectionType);
    }

    public static Card random() throws IOException {
        final String RANDOM_CARD_URL = "https://api.scryfall.com/cards/random";
        URL url = new URL(RANDOM_CARD_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        // This line makes the request
        InputStream responseStream = connection.getInputStream();

        // Manually converting the response body InputStream to APOD using Jackson
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Card>(){}.getType();
        String text = new BufferedReader(
                new InputStreamReader(responseStream, StandardCharsets.UTF_8)).lines()
                .collect(Collectors.joining("\n"));
        return gson.fromJson(text, collectionType);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getArena_id() {
        return arena_id;
    }

    public void setArena_id(Integer arena_id) {
        this.arena_id = arena_id;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Integer getMtgo_id() {
        return mtgo_id;
    }

    public void setMtgo_id(Integer mtgo_id) {
        this.mtgo_id = mtgo_id;
    }

    public Integer getMtgo_foil_id() {
        return mtgo_foil_id;
    }

    public void setMtgo_foil_id(Integer mtgo_foil_id) {
        this.mtgo_foil_id = mtgo_foil_id;
    }

    public ArrayList<Integer> getMultiverse_ids() {
        return multiverse_ids;
    }

    public void setMultiverse_ids(ArrayList<Integer> multiverse_ids) {
        this.multiverse_ids = multiverse_ids;
    }

    public Integer getTcgplayer_id() {
        return tcgplayer_id;
    }

    public void setTcgplayer_id(Integer tcgplayer_id) {
        this.tcgplayer_id = tcgplayer_id;
    }

    public Integer getCardmarket_id() {
        return cardmarket_id;
    }

    public void setCardmarket_id(Integer cardmarket_id) {
        this.cardmarket_id = cardmarket_id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getOracle_id() {
        return oracle_id;
    }

    public void setOracle_id(String oracle_id) {
        this.oracle_id = oracle_id;
    }

    public String getPrints_search_uri() {
        return prints_search_uri;
    }

    public void setPrints_search_uri(String prints_search_uri) {
        this.prints_search_uri = prints_search_uri;
    }

    public String getRulings_url() {
        return rulings_url;
    }

    public void setRulings_url(String rulings_url) {
        this.rulings_url = rulings_url;
    }

    public String getScryfall_uri() {
        return scryfall_uri;
    }

    public void setScryfall_uri(String scryfall_uri) {
        this.scryfall_uri = scryfall_uri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ArrayList<RelatedCard> getAll_parts() {
        return all_parts;
    }

    public void setAll_parts(ArrayList<RelatedCard> all_parts) {
        this.all_parts = all_parts;
    }

    public ArrayList<CardFace> getCard_faces() {
        return card_faces;
    }

    public void setCard_faces(ArrayList<CardFace> card_faces) {
        this.card_faces = card_faces;
    }

    public Double getCmc() {
        return cmc;
    }

    public void setCmc(Double cmc) {
        this.cmc = cmc;
    }

    public ArrayList<String> getColor_identity() {
        return color_identity;
    }

    public void setColor_identity(ArrayList<String> color_identity) {
        this.color_identity = color_identity;
    }

    public ArrayList<String> getColor_indicator() {
        return color_indicator;
    }

    public void setColor_indicator(ArrayList<String> color_indicator) {
        this.color_indicator = color_indicator;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public Integer getEdhrec_rank() {
        return edhrec_rank;
    }

    public void setEdhrec_rank(Integer edhrec_rank) {
        this.edhrec_rank = edhrec_rank;
    }

    public Boolean getFoil() {
        return foil;
    }

    public void setFoil(Boolean foil) {
        this.foil = foil;
    }

    public String getHand_modifier() {
        return hand_modifier;
    }

    public void setHand_modifier(String hand_modifier) {
        this.hand_modifier = hand_modifier;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public String getLife_modifier() {
        return life_modifier;
    }

    public void setLife_modifier(String life_modifier) {
        this.life_modifier = life_modifier;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getMana_cost() {
        return mana_cost;
    }

    public void setMana_cost(String mana_cost) {
        this.mana_cost = mana_cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNonfoil() {
        return nonfoil;
    }

    public void setNonfoil(Boolean nonfoil) {
        this.nonfoil = nonfoil;
    }

    public String getOracle_text() {
        return oracle_text;
    }

    public void setOracle_text(String oracle_text) {
        this.oracle_text = oracle_text;
    }

    public Boolean getOversized() {
        return oversized;
    }

    public void setOversized(Boolean oversized) {
        this.oversized = oversized;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public ArrayList<String> getProduced_mana() {
        return produced_mana;
    }

    public void setProduced_mana(ArrayList<String> produced_mana) {
        this.produced_mana = produced_mana;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public String getType_line() {
        return type_line;
    }

    public void setType_line(String type_line) {
        this.type_line = type_line;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Boolean getBooster() {
        return booster;
    }

    public void setBooster(Boolean booster) {
        this.booster = booster;
    }

    public String getBorder_color() {
        return border_color;
    }

    public void setBorder_color(String border_color) {
        this.border_color = border_color;
    }

    public String getCard_back_id() {
        return card_back_id;
    }

    public void setCard_back_id(String card_back_id) {
        this.card_back_id = card_back_id;
    }

    public String getCollector_number() {
        return collector_number;
    }

    public void setCollector_number(String collector_number) {
        this.collector_number = collector_number;
    }

    public Boolean getContent_warning() {
        return content_warning;
    }

    public void setContent_warning(Boolean content_warning) {
        this.content_warning = content_warning;
    }

    public Boolean getDigital() {
        return digital;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public String getFlavor_name() {
        return flavor_name;
    }

    public void setFlavor_name(String flavor_name) {
        this.flavor_name = flavor_name;
    }

    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }

    public ArrayList<String> getFrame_effects() {
        return frame_effects;
    }

    public void setFrame_effects(ArrayList<String> frame_effects) {
        this.frame_effects = frame_effects;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public Boolean getFull_art() {
        return full_art;
    }

    public void setFull_art(Boolean full_art) {
        this.full_art = full_art;
    }

    public ArrayList<String> getGames() {
        return games;
    }

    public void setGames(ArrayList<String> games) {
        this.games = games;
    }

    public Boolean getHighres_image() {
        return highres_image;
    }

    public void setHighres_image(Boolean highres_image) {
        this.highres_image = highres_image;
    }

    public String getIllustration_id() {
        return illustration_id;
    }

    public void setIllustration_id(String illustration_id) {
        this.illustration_id = illustration_id;
    }

    public String getImage_status() {
        return image_status;
    }

    public void setImage_status(String image_status) {
        this.image_status = image_status;
    }

    public ImageUris getImage_uris() {
        return image_uris;
    }

    public void setImage_uris(ImageUris image_uris) {
        this.image_uris = image_uris;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public String getPrinted_name() {
        return printed_name;
    }

    public void setPrinted_name(String printed_name) {
        this.printed_name = printed_name;
    }

    public String getPrinted_text() {
        return printed_text;
    }

    public void setPrinted_text(String printed_text) {
        this.printed_text = printed_text;
    }

    public String getPrinted_type_line() {
        return printed_type_line;
    }

    public void setPrinted_type_line(String printed_type_line) {
        this.printed_type_line = printed_type_line;
    }

    public Boolean getPromo() {
        return promo;
    }

    public void setPromo(Boolean promo) {
        this.promo = promo;
    }

    public ArrayList<String> getPromo_types() {
        return promo_types;
    }

    public void setPromo_types(ArrayList<String> promo_types) {
        this.promo_types = promo_types;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public RelatedUris getRelated_uris() {
        return related_uris;
    }

    public void setRelated_uris(RelatedUris related_uris) {
        this.related_uris = related_uris;
    }

    public String getReleased_at() {
        return released_at;
    }

    public void setReleased_at(String released_at) {
        this.released_at = released_at;
    }

    public Boolean getReprint() {
        return reprint;
    }

    public void setReprint(Boolean reprint) {
        this.reprint = reprint;
    }

    public String getScryfall_set_uri() {
        return scryfall_set_uri;
    }

    public void setScryfall_set_uri(String scryfall_set_uri) {
        this.scryfall_set_uri = scryfall_set_uri;
    }

    public String getSet_name() {
        return set_name;
    }

    public void setSet_name(String set_name) {
        this.set_name = set_name;
    }

    public String getSet_search_uri() {
        return set_search_uri;
    }

    public void setSet_search_uri(String set_search_uri) {
        this.set_search_uri = set_search_uri;
    }

    public String getSet_type() {
        return set_type;
    }

    public void setSet_type(String set_type) {
        this.set_type = set_type;
    }

    public String getSet_uri() {
        return set_uri;
    }

    public void setSet_uri(String set_uri) {
        this.set_uri = set_uri;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public Boolean getStory_splotlight() {
        return story_splotlight;
    }

    public void setStory_splotlight(Boolean story_splotlight) {
        this.story_splotlight = story_splotlight;
    }

    public Boolean getTextless() {
        return textless;
    }

    public void setTextless(Boolean textless) {
        this.textless = textless;
    }

    public Boolean getVariation() {
        return variation;
    }

    public void setVariation(Boolean variation) {
        this.variation = variation;
    }

    public String getVariation_of() {
        return variation_of;
    }

    public void setVariation_of(String variation_of) {
        this.variation_of = variation_of;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

}
