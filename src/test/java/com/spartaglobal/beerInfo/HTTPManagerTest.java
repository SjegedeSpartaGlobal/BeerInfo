package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.RequestInputSuite.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestInputSuite.PropertiesReader;
import com.spartaglobal.beerInfo.model.RequestInputSuite.RequestToJSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class HTTPManagerTest {

    @Test
    public void testHTTPManger(){
        HTTPManager httpManager = new HTTPManager(PropertiesReader.getBeersEndPoint());
        RequestToJSONArray reader  = new RequestToJSONArray(httpManager.getResponseBody());
        JSONArray beerArray = reader.getJSONArray();
        JSONObject beer = (JSONObject) beerArray.get(1);
        Assert.assertEquals("Trashy Blonde", beer.get("name"));
    }
}
