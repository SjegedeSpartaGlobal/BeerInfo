package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestReaderToJSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class HTTPManagerTest {

    @Test
    public void testMakeAllBeers(){
        HTTPManager httpManager = new HTTPManager();
        RequestReaderToJSONArray reader  = new RequestReaderToJSONArray(httpManager.getResponseBody());
        JSONArray beerArray = reader.getJSONArray();
        JSONObject beer = (JSONObject) beerArray.get(1);
        Assert.assertEquals("Trashy Blonde", beer.get("name"));
    }
}
