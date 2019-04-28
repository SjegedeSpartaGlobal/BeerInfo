package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeerSearcherTest {

    private static BeerSearcher bs;

    @BeforeClass
    public static void setUpBeerSearcher(){
        QueryStringCreator queryCreator = new QueryStringCreator("Berliner Weisse");
        String queryString = queryCreator.getQueryString();
        bs = new BeerSearcher(queryString);
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(3, bs.getAmout());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("Japanese Citrus Berliner Weisse.", bs.getFirstBeer().get("tagline"));
    }

    @Test
    public void testGetRandomBeer(){
        long berlinerIBU = (long) bs.selectRandomBeer().get("ibu");
        Assert.assertEquals(8, berlinerIBU);
    }

    @Test
    public void testGetBeerNames(){
        String[] berlinerNames = {"Berliner Weisse With Yuzu - B-Sides", "Berliner Weisse With Raspberries And Rhubarb - B-Sides",
                "Blitz Berliner Weisse"};
        Assert.assertArrayEquals(berlinerNames, bs.getBeerNames());
    }
}

