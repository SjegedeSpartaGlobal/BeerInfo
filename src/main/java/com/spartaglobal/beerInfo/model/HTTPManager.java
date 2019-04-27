package com.spartaglobal.beerInfo.model;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPManager {

    private CloseableHttpResponse fullResponse;

    public HTTPManager() {
        makeAllBeersCall();
    }

    //cornstructor methods
    private void makeAllBeersCall() {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getLatestRates = new HttpGet(PropertiesReader.getBaseURL() + PropertiesReader.getBeersEndPoint());
            System.out.println(PropertiesReader.getBaseURL() + PropertiesReader.getBeersEndPoint());
            fullResponse = httpClient.execute(getLatestRates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Accessor methods
    public String getResponseBody() {
        String bodyResult = null;

        try {
            bodyResult = EntityUtils.toString(fullResponse.getEntity());

        } catch (IOException e) {

        }
        return bodyResult;
    }
}