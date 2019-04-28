package com.spartaglobal.beerInfo.model.BeerInfoDTO;

import org.json.simple.JSONObject;

public class BeerInfoDTO {
    private String name;
    private long alcContent;
    private double bitternessRating;
    private String[] foodPairings;
    private String description;


    public BeerInfoDTO(JSONObject jsonInput) {
        name = (String) jsonInput.get("name");
        alcContent = (long) jsonInput.get("abv");
        bitternessRating = (double) jsonInput.get("ibu");
        foodPairings = (String[]) jsonInput.get("food");
        description = (String) jsonInput.get("description");
    }

    public String getName() {
        return name;
    }

    public long getAlcContent() {
        return alcContent;
    }

    public double getBitternessRating() {
        return bitternessRating;
    }

    public String[] getFoodPairings() {
        return foodPairings;
    }

    public String getDescription() {
        return description;
    }
}
