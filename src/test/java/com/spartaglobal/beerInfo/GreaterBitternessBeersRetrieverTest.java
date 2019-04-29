package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.IBUException;
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
        Assert.assertEquals(2, beersRetriever.getAmount());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("Sink The Bismarck!", beersRetriever.getFirstBeer().getName());
    }

    @Test
    public void testGetRandomBeer(){
        double bitterness = 0;
        try {
            bitterness = (double) beersRetriever.selectRandomBeer().getBitternessRating();
        } catch (IBUException e) {
            e.printStackTrace();
        }
        System.out.println(bitterness);
    }

    @Test
    public void testGetBeerNames(){
        String[] highBitternessNames = {"Sink The Bismarck!", "Tactical Nuclear Penguin"};
        Assert.assertArrayEquals(highBitternessNames, beersRetriever.getBeerNames());
    }
}
