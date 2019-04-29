package com.spartaglobal.beerInfo.model.BeerInfoServices;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Random;

public class BeerInfoService {

    protected JSONArray beerServiceArray;

    public int getAmount(){
        return beerServiceArray.size();
    }

    public BeerInfoDTO getFirstBeer(){
        JSONObject jsonObject = (JSONObject) beerServiceArray.get(0);
        BeerInfoDTO beerInfoDTO = new BeerInfoDTO(jsonObject);
        return  beerInfoDTO;
    }

    public BeerInfoDTO selectRandomBeer(){
        Random r = new Random();
        int length = beerServiceArray.size();
        int randPos = r.nextInt(length);
        JSONObject jsonObject = (JSONObject) beerServiceArray.get(randPos);
        BeerInfoDTO beerInfoDTO = new BeerInfoDTO(jsonObject);

        return beerInfoDTO;
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
