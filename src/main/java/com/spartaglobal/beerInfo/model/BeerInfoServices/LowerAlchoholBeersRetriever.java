package com.spartaglobal.beerInfo.model.BeerInfoServices;

import com.spartaglobal.beerInfo.model.RequestInputSuite.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestInputSuite.PropertiesReader;
import com.spartaglobal.beerInfo.model.RequestInputSuite.RequestReaderToJSONArray;
import org.json.simple.JSONArray;

public class LowerAlchoholBeersRetriever {
    private JSONArray beerArray;

    public GreaterAlchoholBeersRetreiver(String alcVol) {
        HTTPManager httpManager = new HTTPManager(PropertiesReader.getBeersEndPoint()+alcVol);
        RequestReaderToJSONArray reader  = new RequestReaderToJSONArray(httpManager.getResponseBody());
        beerArray = reader.getJSONArray();
    }

    public int getAmoutOfBeers(){
        return beerArray.size();
    }
}
