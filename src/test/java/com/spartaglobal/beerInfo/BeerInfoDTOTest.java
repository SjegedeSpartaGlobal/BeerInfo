package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeerInfoDTOTest {

    private static BeerInfoDTO beerInfo;

    @BeforeClass
    public static void setUpBeerInfo(){
        QueryStringCreator queryCreator = new QueryStringCreator("Berliner Weisse");
        String queryString = queryCreator.getQueryString();
        BeerSearcher bs  = new BeerSearcher(queryString);
        beerInfo = new BeerInfoDTO(bs.getFirstBeer());
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
        Assert.assertEquals(8, (long) beerInfo.getBitternessRating());
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
