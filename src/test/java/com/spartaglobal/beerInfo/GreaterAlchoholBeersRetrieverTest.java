package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.GreaterAlchoholBeersRetreiver;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class GreaterAlchoholBeersRetrieverTest {

    private static GreaterAlchoholBeersRetreiver beerRetriever;

    @BeforeClass
    public static void setUpBeersRetriever(){
        beerRetriever = new GreaterAlchoholBeersRetreiver(40);
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(2, beerRetriever.getAmout());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("The World's Strongest Beer.", beerRetriever.getFirstBeer().get("tagline"));
    }

    @Test
    public void testGetRandomBeer(){
        String highContentAlcBeerContributor = (String) beerRetriever.selectRandomBeer().get("contributed_by");
        Assert.assertEquals("Sam Mason <samjbmason>", highContentAlcBeerContributor);
    }

    @Test
    public void testGetBeerNames(){
        String[] highContentAlcBeerNames = { "The End Of History", "Sink The Bismarck!"};
        Assert.assertArrayEquals(highContentAlcBeerNames, beerRetriever.getBeerNames());
    }

}
