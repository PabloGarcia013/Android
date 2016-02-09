package com.example.cice.openweathermapjson;

import java.util.ArrayList;

/**
 * Created by CICE on 9/2/16.
 */
public class HttpRequestManager {

    /*
    * http://api.openweathermap.org/data/2.5
    * /forecast/daily
    *?q=London&
    *
    **/
    
    private static final String API_KEY = "53d6800cc78467cae9c1a71aae941976";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5";
    private static final String API_SERVIE = "/forecast/daily";


    public static ArrayList<Forecast> getDailyForecast(String city, int days) {
        return null;
    }
}
