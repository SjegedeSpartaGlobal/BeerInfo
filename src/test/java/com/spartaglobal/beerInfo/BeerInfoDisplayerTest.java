package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.controller.BeerInfoServices;
import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import com.spartaglobal.beerInfo.view.BeerInfoDisplayer;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeerInfoDisplayerTest {

    private static BeerInfoDisplayer displayer;

    @BeforeClass
    public static void setDisplayer(){
        BeerInfoServices beerInfo = new BeerInfoServices();
        BeerSearcher bs = beerInfo.searchBeers("Berliner Weisse");
        displayer = new BeerInfoDisplayer(bs.getBeerNames(), bs.getAmout(), "Berliner Weisse");
    }

    @Test
    public void testDisplaySearchResults(){
        displayer.displaySearchResults();
    }
}
