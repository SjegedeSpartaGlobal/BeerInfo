package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import com.spartaglobal.beerInfo.model.BeerInfoDTO.IBUException;
import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import com.spartaglobal.beerInfo.model.RequestInputSuite.HTTPManager;
import com.spartaglobal.beerInfo.model.RequestInputSuite.PropertiesReader;
import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import com.spartaglobal.beerInfo.model.RequestInputSuite.RequestToJSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeerInfoDTOTest {

    private static BeerInfoDTO beerInfo;

    @BeforeClass
    public static void setUpBeerInfo(){
        HTTPManager httpManager = new HTTPManager(PropertiesReader.getNameQuery("Berliner Weisse"));
        RequestToJSONArray reader  = new RequestToJSONArray(httpManager.getResponseBody());
        JSONArray beerArray = reader.getJSONArray();
        beerInfo = new BeerInfoDTO((JSONObject) beerArray.get(0));
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("Berliner Weisse With Yuzu - B-Sides", beerInfo.getName());
    }

    @Test
    public void testGetAlcContent(){
        Assert.assertEquals(4.2, (double) beerInfo.getAlcContent(), 0.01);
    }

    @Test
    public void testGetBitternessRating(){
        try {
            Assert.assertEquals(8, (long) beerInfo.getBitternessRating());
        } catch (IBUException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFoodPairings(){
        String[] foods = {"Smoked chicken wings", "Miso ramen", "Yuzu cheesecake"};
        Assert.assertArrayEquals(foods, beerInfo.getFoodPairings());
    }

    @Test
    public void testGetDescription(){
        String description = "Japanese citrus fruit intensifies the sour nature of this German classic.";
        Assert.assertEquals(description, beerInfo.getDescription());
    }

}
