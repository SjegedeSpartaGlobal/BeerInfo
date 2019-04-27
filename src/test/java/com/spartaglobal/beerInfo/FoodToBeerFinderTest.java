package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.FoodToBeerFinder;
import org.junit.Assert;
import org.junit.Test;

public class FoodToBeerFinderTest {

    @Test
    public void testGetAmount(){
        FoodToBeerFinder beerFinder = new FoodToBeerFinder("Cheesecake with a passion fruit swirl sauce");
//        Assert.assertEquals(bs.getAmout(),1);
        System.out.println(beerFinder.getAmout());
    }
}
