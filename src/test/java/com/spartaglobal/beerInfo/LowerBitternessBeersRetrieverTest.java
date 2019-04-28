package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.LowerBitternessBeersRetriever;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LowerBitternessBeersRetrieverTest {

    private static LowerBitternessBeersRetriever beersRetriever;

    @BeforeClass
    public static void setUpBeersRetriever(){
        beersRetriever = new LowerBitternessBeersRetriever(5);
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(6,beersRetriever.getAmout());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("The World's Strongest Beer.", beersRetriever.getFirstBeer().get("tagline"));
    }

    @Test
    public void testGetRandomBeer(){
        String lowBitternessBeerContributor = (String) beersRetriever.selectRandomBeer().get("contributed_by");
        Assert.assertEquals("Sam Mason <samjbmason>", lowBitternessBeerContributor);
    }

    @Test
    public void testGetBeerNames(){
        String[] lowBitternessNames = {"The End Of History", "AB:19", "International Arms Race (w/ Flying Dog)",
                "Mango And Chili Barley Wine", "Science IPA", "Honey And Lemon Blitz"};
        Assert.assertArrayEquals(lowBitternessNames, beersRetriever.getBeerNames());
    }
}
