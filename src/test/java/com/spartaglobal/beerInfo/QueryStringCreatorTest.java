package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import org.junit.Assert;
import org.junit.Test;

public class QueryStringCreatorTest {

    @Test
    public void getQueryString(){
        QueryStringCreator queryCreator = new QueryStringCreator("Cheesecake with a passion fruit swirl sauce");
        Assert.assertEquals("Cheesecake_with_a_passion_fruit_swirl_sauce" ,queryCreator.getQueryString());
    }
}
