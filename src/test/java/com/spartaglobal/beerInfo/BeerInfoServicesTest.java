package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.controller.BeerInfoServices;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeerInfoServicesTest {

    private static BeerInfoServices beerInfo;

    @BeforeClass
    public static void setUpBeerInfo(){
        beerInfo = new BeerInfoServices();
    }

    @Test
    public void testSearchBeers(){
        Assert.assertEquals("Berliner Weisse With Yuzu - B-Sides", beerInfo.searchBeers("Berliner Weisse").getBeerNames()[0]);
    }

    @Test
    public void testBeersMatchingFood(){
        Assert.assertEquals(2, beerInfo.beersMatchingFood("Cheesecake with a passion fruit swirl sauce").getAmount());
    }

    @Test
    public void testGetHighAlcContent(){
        Assert.assertEquals(2, beerInfo.getHighAlcContent(40).getAmount());
    }

    @Test
    public void testLowHighAlcContent(){
        Assert.assertEquals(2, beerInfo.getLowAlcContent(1).getAmount());
    }

    @Test
    public void testGetHighBitternessBeers(){
        Assert.assertEquals(2, beerInfo.getHighBittenessBeers(1010).getAmount());
    }

    @Test
    public void testGetLowBitternessBeers(){
        Assert.assertEquals(6, beerInfo.getLowBittenessBeers(5).getAmount());
    }
}
