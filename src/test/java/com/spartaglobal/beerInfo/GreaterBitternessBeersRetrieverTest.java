package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.GreaterBitternessBeersRetriever;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GreaterBitternessBeersRetrieverTest {

    private static GreaterBitternessBeersRetriever beersRetriever;

    @BeforeClass
    public static void setUpBeerRetriever(){
        beersRetriever = new GreaterBitternessBeersRetriever(1010);
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(2, beersRetriever.getAmout());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("IPA For The Dedicated.", beersRetriever.getFirstBeer().get("tagline"));
    }

    @Test
    public void testGetRandomBeer(){
        double highBitternessPH = (double) beersRetriever.selectRandomBeer().get("ph");
        Assert.assertEquals(4.4, highBitternessPH, 0.01);
    }

    @Test
    public void testGetBeerNames(){
        String[] highBitternessNames = {"Sink The Bismarck!", "Tactical Nuclear Penguin"};
        Assert.assertArrayEquals(highBitternessNames, beersRetriever.getBeerNames());
    }
}
