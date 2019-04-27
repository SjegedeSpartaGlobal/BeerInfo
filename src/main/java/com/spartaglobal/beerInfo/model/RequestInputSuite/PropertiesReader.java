package com.spartaglobal.beerInfo.model.RequestInputSuite;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties;
    private static  String baseURL;
    private static String beersEndPoint;
    private static String greaterAlcVol;
    private static String lessAlcVol;
    private static String greaterBitterness;
    private static String lessBitterness;
    private static String nameQuery;
    private static String foodQuery;

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

    public static String getNameQuery(String param){
        if(nameQuery==null){
            setUp();
        }

        return nameQuery + param;
    }

    public static String getFoodQuery(String param){
        if(foodQuery==null){
            setUp();
        }

        return foodQuery + param;
    }

    public static String getGreaterAlcVol(String param){
        if(greaterAlcVol==null){
            setUp();
        }

        return greaterAlcVol + param;
    }

    public static String getLessAlcVol(String param){
        if(lessAlcVol==null){
            setUp();
        }

        return lessAlcVol + param;
    }

    public static String getGreaterBitterness(String param){
        if(greaterBitterness==null){
            setUp();
        }

        return greaterBitterness + param;
    }

    public static String getLessBitterness(String param){
        if(lessBitterness==null){
            setUp();
        }

        return lessBitterness + param;
    }

    private static void setUp(){
        try {
            properties = new Properties();
            properties.load(new FileReader("resources/beer_info.properties"));
            baseURL = properties.getProperty("base_URL");
            beersEndPoint = properties.getProperty("beers_endpoint");
            greaterAlcVol = properties.getProperty("more_alc_vol_than");
            lessAlcVol = properties.getProperty("less_alc_vol_than");
            greaterBitterness = properties.getProperty("bitter_ibu_than");
            lessBitterness = properties.getProperty("less_bitter_ibu_than");
            nameQuery = properties.getProperty("search_by_name");
            foodQuery = properties.getProperty("search_by_food");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
