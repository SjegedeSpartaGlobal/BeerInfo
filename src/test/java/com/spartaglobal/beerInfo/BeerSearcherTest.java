package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.IBUException;
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
        Assert.assertEquals(3, bs.getAmount());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("Berliner Weisse With Yuzu - B-Sides", bs.getFirstBeer().getName());
    }

    @Test
    public void testGetRandomBeer(){
        long berlinerIBU = 0;
        try {
            berlinerIBU = (long) bs.selectRandomBeer().getBitternessRating();
        } catch (IBUException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(8, berlinerIBU);
    }

    @Test
    public void testGetBeerNames(){
        String[] berlinerNames = {"Berliner Weisse With Yuzu - B-Sides", "Berliner Weisse With Raspberries And Rhubarb - B-Sides",
                "Blitz Berliner Weisse"};
        Assert.assertArrayEquals(berlinerNames, bs.getBeerNames());
    }
}

