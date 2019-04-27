package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import org.junit.Assert;
import org.junit.Test;

public class BeerSearcherTest {

    @Test
    public void testGetAmount(){
        QueryStringCreator queryCreator = new QueryStringCreator("AB:06");
        String queryString = queryCreator.getQueryString();
        BeerSearcher bs = new BeerSearcher(queryString);
        Assert.assertEquals(bs.getAmout(),1);
    }
}
