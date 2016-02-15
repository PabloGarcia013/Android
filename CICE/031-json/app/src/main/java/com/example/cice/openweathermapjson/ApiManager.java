package com.example.cice.openweathermapjson;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by CICE on 9/2/16.
 */
public class ApiManager {

    private static ApiManager mInstance;
    Context context;
    HttpRequestManager httpRequestManager;

    public static ApiManager getInstance(Context context){

        if (mInstance == null){
            mInstance = new ApiManager(context);
        }
        return mInstance;
    }

    private ApiManager(Context context) {
        this.context = context;
        this.httpRequestManager = new HttpRequestManager();
    }

    public ArrayList<Forecast> getDailyForecast(String city, int days) throws HttpException {
        return httpRequestManager.getDailyForecast(city, days);
    }


}
