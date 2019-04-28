package com.spartaglobal.beerInfo.model.BeerInfoServices;

import com.spartaglobal.beerInfo.model.RequestInputSuite.QueryStringCreator;

public class BeerInfoServices {
    private BeerSearcher beerSearcher;
    private FoodToBeerFinder foodBeerSearcher;
    private GreaterAlchoholBeersRetreiver highAlcBeerFinder;
    private LowerAlchoholBeersRetriever lowAlcBeerFinder;
    private GreaterBitternessBeersRetriever highBitternessBeerFinder;
    private LowerBitternessBeersRetriever lowBitternessBeerFinder;

    public BeerSearcher searchBeers(String str){
        QueryStringCreator queryCreator = new QueryStringCreator(str);
        String queryString = queryCreator.getQueryString();
        beerSearcher = new BeerSearcher(queryString);

        return beerSearcher;
    }

    public FoodToBeerFinder beersMatchingFood(String str){
        QueryStringCreator queryCreator = new QueryStringCreator(str);
        String queryString = queryCreator.getQueryString();
        foodBeerSearcher = new FoodToBeerFinder(queryString);

        return foodBeerSearcher;
    }

    public GreaterAlchoholBeersRetreiver getHighAlcContent(int alcVol){
        highAlcBeerFinder = new GreaterAlchoholBeersRetreiver(alcVol);

        return highAlcBeerFinder;
    }

    public LowerAlchoholBeersRetriever getLowAlcContent(int alcVol){
        lowAlcBeerFinder = new LowerAlchoholBeersRetriever(alcVol);

        return lowAlcBeerFinder;
    }

    public GreaterBitternessBeersRetriever getHighBittenessBeers(int ibu){
        highBitternessBeerFinder = new GreaterBitternessBeersRetriever(ibu);

        return highBitternessBeerFinder;
    }

    public LowerBitternessBeersRetriever getLowBittenessBeers(int ibu){
        lowBitternessBeerFinder = new LowerBitternessBeersRetriever(ibu);

        return lowBitternessBeerFinder;
    }

}
