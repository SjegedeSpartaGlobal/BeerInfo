package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.LowerAlchoholBeersRetriever;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LowerAlchoholBeersRetrieverTest {

    private static LowerAlchoholBeersRetriever beersRetriever;

    @BeforeClass
    public static void setUpBeerRetriever(){
        beersRetriever = new LowerAlchoholBeersRetriever(1);
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(2, beersRetriever.getAmount());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("Nanny State", beersRetriever.getFirstBeer().getName());
    }

    @Test
    public void testGetRandomBeer(){
        double lowContentAlcContent = (double) beersRetriever.selectRandomBeer().getAlcContent();
        Assert.assertEquals(0.5, lowContentAlcContent, 0.01);
    }

    @Test
    public void testGetBeerNames(){
        String[] highContentAlcBeerNames = { "Nanny State", "Raspberry Popsicle Parade"};
        Assert.assertArrayEquals(highContentAlcBeerNames, beersRetriever.getBeerNames());
    }
}
