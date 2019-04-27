package com.spartaglobal.beerInfo.model;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPManager {

    private CloseableHttpResponse fullResponse;

    public HTTPManager(String endPoint) {
        makeAllBeersCall(endPoint);
    }

    //cornstructor methods
    private void makeAllBeersCall(String endPoint) {
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet getRequest = new HttpGet(PropertiesReader.getBaseURL() + endPoint);
            System.out.println(PropertiesReader.getBaseURL() + PropertiesReader.getBeersEndPoint());
            fullResponse = httpClient.execute(getRequest);
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