package com.example.cice.openweathermapjson;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by CICE on 9/2/16.
 */
public class ApiManager {


    HttpRequestManager httpRequestManager;

    //Mirar en chrome extensions : jsonview para ver los json.


    public ApiManager() {
        this.httpRequestManager = new HttpRequestManager();
    }

    public ArrayList<Forecast> getDailyForecast(String city, int days) throws HttpException {
        return httpRequestManager.getDailyForecast(city, days);
    }


}
