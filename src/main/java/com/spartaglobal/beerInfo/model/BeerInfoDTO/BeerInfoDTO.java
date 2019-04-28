package com.spartaglobal.beerInfo.model.BeerInfoDTO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BeerInfoDTO {
    private String name;
    private double alcContent;
    private long bitternessRating;
    private String[] foodPairings;
    private String description;


    public BeerInfoDTO(JSONObject jsonInput) {
        String next;
        name = (String) jsonInput.get("name");
        alcContent = (double) jsonInput.get("abv");
        bitternessRating = (long) jsonInput.get("ibu");
        description = (String) jsonInput.get("description");
        JSONArray JArray = (JSONArray) jsonInput.get("food_pairing");
        foodPairings = new String[JArray.size()];

        for(int i=0; i<JArray.size(); i++){
            next = (String) JArray.get(i);
            foodPairings[i] = next;
        }
    }

    public String getName() {
        return name;
    }

    public double getAlcContent() {
        return alcContent;
    }

    public long getBitternessRating() {
        return bitternessRating;
    }

    public String[] getFoodPairings() {
        return foodPairings;
    }

    public String getDescription() {
        return description;
    }
}
