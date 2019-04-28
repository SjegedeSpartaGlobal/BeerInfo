package com.spartaglobal.beerInfo;

import com.spartaglobal.beerInfo.model.BeerInfoDTO.BeerInfoDTO;
import com.spartaglobal.beerInfo.model.BeerInfoServices.BeerSearcher;
import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;
import com.spartaglobal.beerInfo.view.BeerInfoDTODisplayer;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeerInfoDTODisplayerTest {
    private static BeerInfoDTODisplayer beerInfoDTO;

    @BeforeClass
    public static void setBeerInfoDTO(){
        QueryStringCreator queryCreator = new QueryStringCreator("Berliner Weisse");
        String queryString = queryCreator.getQueryString();
        BeerSearcher bs  = new BeerSearcher(queryString);
        BeerInfoDTO dto = new BeerInfoDTO(bs.getFirstBeer());
        beerInfoDTO = new BeerInfoDTODisplayer(dto);
    }

    @Test
    public void testDisplayBeerInfoDTO(){
        beerInfoDTO.displayBeerInfoDTO();
    }
}
