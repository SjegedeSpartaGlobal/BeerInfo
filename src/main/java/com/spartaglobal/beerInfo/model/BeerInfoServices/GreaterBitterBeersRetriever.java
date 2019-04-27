package com.spartaglobal.beerInfo.model.BeerInfoServices;

import com.spartaglobal.beerInfo.model.RequestInputSuite.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestInputSuite.PropertiesReader;
import com.spartaglobal.beerInfo.model.RequestInputSuite.RequestReaderToJSONArray;
import org.json.simple.JSONArray;

public class GreaterBitterBeersRetriever extends BeerInfoService{

    private JSONArray beerArray;

    public GreaterBitterBeersRetriever(String ibu) {
        HTTPManager httpManager = new HTTPManager(PropertiesReader.getGreaterBitterness(ibu));
        RequestReaderToJSONArray reader  = new RequestReaderToJSONArray(httpManager.getResponseBody());
        beerArray = reader.getJSONArray();
        super.beerServiceArray = beerArray;
    }
}
