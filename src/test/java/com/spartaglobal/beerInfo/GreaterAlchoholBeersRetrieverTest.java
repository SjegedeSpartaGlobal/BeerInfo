package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.GreaterAlchoholBeersRetreiver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GreaterAlchoholBeersRetrieverTest {

    private static GreaterAlchoholBeersRetreiver beersRetreiver;

    @BeforeClass
    public static void setUpBeersRetriever(){
        beersRetreiver = new GreaterAlchoholBeersRetreiver(40);
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(2, beersRetreiver.getAmount());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("The End Of History", beersRetreiver.getFirstBeer().getName());
    }

    @Test
    public void testGetRandomBeer(){
        String highContentAlcBeerName = (String) beersRetreiver.selectRandomBeer().getName();
        System.out.println(highContentAlcBeerName);
    }

    @Test
    public void testGetBeerNames(){
        String[] highContentAlcBeerNames = { "The End Of History", "Sink The Bismarck!"};
        Assert.assertArrayEquals(highContentAlcBeerNames, beersRetreiver.getBeerNames());
    }

}
