package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.FoodToBeerFinder;
import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import org.junit.Assert;
import org.junit.Test;

public class FoodToBeerFinderTest {

    @Test
    public void testGetAmount(){
        QueryStringCreator queryCreator = new QueryStringCreator("Cheesecake with a passion fruit swirl sauce");
        String queryString = queryCreator.getQueryString();
        FoodToBeerFinder beerFinder = new FoodToBeerFinder(queryString);
        Assert.assertEquals(2, beerFinder.getAmout());
    }
}
