package com.spartaglobal.beerInfo.model.BeerInfoServices;

import com.spartaglobal.beerInfo.model.RequestInputSuite.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestInputSuite.PropertiesReader;
import com.spartaglobal.beerInfo.model.RequestInputSuite.RequestReaderToJSONArray;
import org.json.simple.JSONArray;

public class FoodToBeerFinder {

    private JSONArray beerArray;

    public FoodToBeerFinder(String param) {
        HTTPManager httpManager = new HTTPManager(PropertiesReader.getFoodQuery(param));
        RequestReaderToJSONArray reader  = new RequestReaderToJSONArray(httpManager.getResponseBody());
        beerArray = reader.getJSONArray();
    }
}
