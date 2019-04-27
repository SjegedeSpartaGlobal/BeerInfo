package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import org.junit.Assert;
import org.junit.Test;

public class BeerInfoServicesTest {

    @Test
    public void getBeerSearcher(){
        BeerSearcher bs = new BeerSearcher("AB:06");
        Assert.assertEquals(bs.getAmout(),1);
    }
}
