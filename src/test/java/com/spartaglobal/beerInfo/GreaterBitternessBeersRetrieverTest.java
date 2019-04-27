package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.GreaterBitternessBeersRetriever;
import org.junit.Assert;
import org.junit.Test;

public class GreaterBitternessBeersRetrieverTest {

    @Test
    public void testGetAmount(){
        GreaterBitternessBeersRetriever beersRetriever = new GreaterBitternessBeersRetriever(1010);
        Assert.assertEquals(2, beersRetriever.getAmout());
    }
}
