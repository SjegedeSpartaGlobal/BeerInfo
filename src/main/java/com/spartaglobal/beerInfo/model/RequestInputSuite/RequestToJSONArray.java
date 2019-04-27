package com.spartaglobal.beerInfo.model.RequestInputSuite;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RequestToJSONArray {
    private JSONArray JArray;
    private JSONParser parser;

    public RequestToJSONArray(String jsonString) {
        try {
            parser = new JSONParser();
            JArray = (JSONArray) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JSONArray getJSONArray() {
        return JArray;
    }
}


