package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.LowerBitternessBeersRetriever;
import org.junit.Assert;
import org.junit.Test;

public class LowerBitternessBeersRetrieverTest {

    @Test
    public void testGetAmount(){
        LowerBitternessBeersRetriever beersRetriever = new LowerBitternessBeersRetriever(5);
        Assert.assertEquals(6,beersRetriever.getAmout());
    }
}
