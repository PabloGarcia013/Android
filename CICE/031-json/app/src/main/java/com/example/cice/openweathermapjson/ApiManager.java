package com.example.cice.openweathermapjson;

import java.util.ArrayList;

/**
 * Created by CICE on 9/2/16.
 */
public class ApiManager {

    //Mirar en chrome extensions : jsonview para ver los json.

    public ArrayList<Forecast> getDailyForecast(String city, int days){
        return HttpRequestManager.getDailyForecast(city, days);
    }


}
