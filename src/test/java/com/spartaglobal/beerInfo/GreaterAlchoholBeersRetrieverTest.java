package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.GreaterAlchoholBeersRetreiver;
import org.junit.Assert;
import org.junit.Test;

public class GreaterAlchoholBeersRetrieverTest {

    @Test
    public void testGetAmount(){
        GreaterAlchoholBeersRetreiver beerRetriever = new GreaterAlchoholBeersRetreiver(54);
        Assert.assertEquals(1, beerRetriever.getAmout());
    }
}
