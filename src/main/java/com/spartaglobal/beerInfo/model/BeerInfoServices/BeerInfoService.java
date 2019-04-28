package com.spartaglobal.beerInfo.model.BeerInfoServices;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Random;

public class BeerInfoService {

    protected JSONArray beerServiceArray;

    public int getAmount(){
        return beerServiceArray.size();
    }

    public JSONObject getFirstBeer(){
        return (JSONObject) beerServiceArray.get(0);
    }

    public JSONObject selectRandomBeer(){
        Random r = new Random();
        int length = beerServiceArray.size();
        int randPos = r.nextInt(length);

        return (JSONObject) beerServiceArray.get(randPos);
    }

    public String[] getBeerNames(){
        int length = beerServiceArray.size();
        String[] names = new String[length];
        JSONObject nextJSON;
        String next;

        for(int i=0; i<length; i++){
            nextJSON = (JSONObject) beerServiceArray.get(i);
            next = (String) nextJSON.get("name");
            names[i] = next;
        }
        return names;
    }
}
