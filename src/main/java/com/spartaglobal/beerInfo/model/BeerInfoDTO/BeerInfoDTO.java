package com.spartaglobal.beerInfo.model.BeerInfoDTO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BeerInfoDTO {
    private String name;
    private long alcContent;
    private long bitternessRating;
    private String[] foodPairings;
    private String description;
    private boolean unknownBitterness;


    public BeerInfoDTO(JSONObject jsonInput) {
        String next;
        name = (String) jsonInput.get("name");
        alcContent = (long) jsonInput.get("abv");
        if(jsonInput.get("ibu")!=null) {
            bitternessRating = (long) jsonInput.get("ibu");
        }else{
            bitternessRating = 0;
            unknownBitterness = true;
        }

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

    public long getAlcContent() {
        return alcContent;
    }

    public long getBitternessRating() throws IBUException{
        if(!unknownBitterness) {
            return bitternessRating;
        }else{
            throw new IBUException("unknown Bitterness");
        }

    }

    public String[] getFoodPairings() {
        return foodPairings;
    }

    public String getDescription() {
        return description;
    }
}
