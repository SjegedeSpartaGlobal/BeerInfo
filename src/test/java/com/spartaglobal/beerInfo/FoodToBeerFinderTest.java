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
        Assert.assertEquals(2, beerFinder.getAmout());
    }

    @Test
    public void testGetFirstBeer(){
        Assert.assertEquals("Post Modern Classic. Spiky. Tropical. Hoppy.", beerFinder.getFirstBeer().get("tagline"));
    }

    @Test
    public void testGetRandomBeer(){
        String cheeseCakeBeerContributor = (String) beerFinder.selectRandomBeer().get("contributed_by");
        Assert.assertEquals("Sam Mason <samjbmason>", cheeseCakeBeerContributor);
    }

    @Test
    public void testGetBeerNames(){
        String[] cheeseCakeBeerNames = { "Punk IPA 2010 - Current", "Punk IPA 2007 - 2010"};
        Assert.assertArrayEquals(cheeseCakeBeerNames, beerFinder.getBeerNames());
    }
}
