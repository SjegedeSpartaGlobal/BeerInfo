package com.spartaglobal.beerInfo.model.BeerInfoDTO;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class BeerInfoDTO {
    private String name;
    private double alcContent;
    private long bitternessRating;
    private String[] foodPairings;
    private String description;
    private boolean unknownBitterness;
    private boolean unknownAlcContent;
    private boolean unknownName;
    private boolean unknownFoodPairings;
    private boolean unknwownDescription;
    private boolean unknownDescription;


    public BeerInfoDTO(JSONObject jsonInput) {
        String next;

        if(!((String) jsonInput.get("name")).equals("")) {
            name = (String) jsonInput.get("name");
        }else{
            name = "";
            unknownName = true;
        }
        if(Double.parseDouble(jsonInput.get("abv").toString())!=0) {
            alcContent = Double.parseDouble(jsonInput.get("abv").toString());
        }else{
            alcContent = 0;
            unknownAlcContent = true;
        }
        if(jsonInput.get("ibu")!=null){
            bitternessRating = Long.parseLong(jsonInput.get("ibu").toString());
        }else{
            bitternessRating = 0;
            unknownBitterness = true;
        }
        if(!((String) jsonInput.get("description")).equals("")) {
            description = (String) jsonInput.get("description");
        }else{
            description = "";
            unknownDescription = true;
        }
//        foodPairings = new String[]{"hello"};
        if(((JSONArray) jsonInput.get("food_pairing"))!=null) {
            JSONArray JArray = (JSONArray) jsonInput.get("food_pairing");
            foodPairings = new String[JArray.size()];

            for(int i=0; i<JArray.size(); i++){
                next = (String) JArray.get(i);
                foodPairings[i] = next;
            }
        }else{
            foodPairings = new String[]{"hello"};
            unknownFoodPairings = true;
        }

    }

    public String getName() {
        return name;
    }

    public double getAlcContent() {
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
