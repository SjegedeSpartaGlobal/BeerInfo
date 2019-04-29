package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.FoodToBeerFinder;
import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class FoodToBeerFinderTest {

    private static FoodToBeerFinder beerFinder;

    @BeforeClass
    public static void setUpBeerFinder(){
        QueryStringCreator queryCreator = new QueryStringCreator("Cheesecake with a passion fruit swirl sauce");
        String queryString = queryCreator.getQueryString();
        beerFinder = new FoodToBeerFinder(queryString);
    }

    @Test
    public void testGetAmount(){
        Assert.assertEquals(2, beerFinder.getAmount());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("Punk IPA 2010 - Current", beerFinder.getFirstBeer().getName());
    }

    @Test
    public void testGetRandomBeer(){
        String cheeseCakeBeerName = (String) beerFinder.selectRandomBeer().getName();
        System.out.println(cheeseCakeBeerName);;
    }

    @Test
    public void testGetBeerNames(){
        String[] cheeseCakeBeerNames = { "Punk IPA 2010 - Current", "Punk IPA 2007 - 2010"};
        Assert.assertArrayEquals(cheeseCakeBeerNames, beerFinder.getBeerNames());
    }
}
