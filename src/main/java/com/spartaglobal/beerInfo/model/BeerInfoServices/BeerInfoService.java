package com.spartaglobal.beerInfo.model.BeerInfoServices;

import org.json.simple.JSONArray;

public class BeerInfoService {

    protected JSONArray beerServiceArray;

    public int getAmout(){
        return beerServiceArray.size();
    }
}
