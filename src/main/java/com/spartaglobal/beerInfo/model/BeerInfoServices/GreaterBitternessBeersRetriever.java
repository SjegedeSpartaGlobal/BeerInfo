package com.spartaglobal.beerInfo.model.BeerInfoServices;

import com.spartaglobal.beerInfo.model.RequestInputSuite.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestInputSuite.PropertiesReader;
import com.spartaglobal.beerInfo.model.RequestInputSuite.RequestToJSONArray;
import org.json.simple.JSONArray;

public class GreaterBitternessBeersRetriever extends BeerInfoService{

    private JSONArray beerArray;

    public GreaterBitternessBeersRetriever(int ibu) {
        HTTPManager httpManager = new HTTPManager(PropertiesReader.getGreaterBitterness(ibu));
        RequestToJSONArray reader  = new RequestToJSONArray(httpManager.getResponseBody());
        beerArray = reader.getJSONArray();
        super.beerServiceArray = beerArray;
    }
}
