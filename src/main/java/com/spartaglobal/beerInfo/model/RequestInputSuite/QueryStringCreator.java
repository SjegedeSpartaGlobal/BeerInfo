package com.spartaglobal.beerInfo.model.RequestInputSuite;

public class QueryStringCreator {

    private String queryString;

    public QueryStringCreator(String param) {
        queryString = param.replace(" ", "_");
    }

    public String getQueryString() {
        return queryString;
    }
}
