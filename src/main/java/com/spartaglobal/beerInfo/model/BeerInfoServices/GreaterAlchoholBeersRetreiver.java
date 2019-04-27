package com.spartaglobal.beerInfo.model.BeerInfoServices;

import com.spartaglobal.beerInfo.model.RequestInputSuite.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestInputSuite.PropertiesReader;
import com.spartaglobal.beerInfo.model.RequestInputSuite.RequestToJSONArray;
import org.json.simple.JSONArray;

public class GreaterAlchoholBeersRetreiver extends BeerInfoService{

    private JSONArray beerArray;

    public GreaterAlchoholBeersRetreiver(int alcVol) {
        HTTPManager httpManager = new HTTPManager(PropertiesReader.getGreaterAlcVol(alcVol));
        RequestToJSONArray reader  = new RequestToJSONArray(httpManager.getResponseBody());
        beerArray = reader.getJSONArray();
        super.beerServiceArray = beerArray;
    }

}
