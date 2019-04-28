package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerInfoServices;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeerInfoServicesTest {

    private static BeerInfoServices beerInfo;

    @BeforeClass
    public static void setUpBeerInfo(){
        beerInfo = new BeerInfoServices();
    }

    @Test
    public void testSearchBeers(){
        Assert.assertEquals("Berliner Weisse With Yuzu - B-Sides", beerInfo.searchBeers("Berliner Weisse").getBeerNames()[0]);
    }


}
