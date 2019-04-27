package com.spartaglobal.beerInfo.model.BeerInfoServices;

import org.json.simple.JSONArray;

public class BeerInfoService {

    private JSONArray JArray;

    public int getAmout(){
        return JArray.size();
    }
}
