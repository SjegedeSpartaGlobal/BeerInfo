package com.spartaglobal.beerInfo.model.RequestInputSuite;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static Properties properties;
    private static  String baseURL;
    private static String beersEndPoint;

    private PropertiesReader() {

    }


    public static String getBaseURL() {
        if(baseURL==null){
            setUp();
        }

        return baseURL;
    }

    public static String getBeersEndPoint(){
        if(beersEndPoint==null){
            setUp();
        }

        return beersEndPoint;
    }

    private static void setUp(){
        try {
            properties = new Properties();
            properties.load(new FileReader("resources/beer_info.properties"));
            baseURL = properties.getProperty("base_URL");
            beersEndPoint = properties.getProperty("beers_endpoint");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
