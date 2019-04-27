package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.LowerAlchoholBeersRetriever;
import org.junit.Assert;
import org.junit.Test;

public class LowerAlchoholBeersRetrieverTest {

    @Test
    public void testGetAmount(){
        LowerAlchoholBeersRetriever beersRetriever = new LowerAlchoholBeersRetriever(1);
        Assert.assertEquals(2, beersRetriever.getAmout());
    }
}
