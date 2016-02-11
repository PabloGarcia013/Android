package com.example.cice.openweathermapjson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

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

    HttpRequestHelper httpRequestHelper;

    private static final String API_KEY = "53d6800cc78467cae9c1a71aae941976";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5";
    private static final String API_SERVICE = "/forecast/daily";


    public HttpRequestManager() {

        httpRequestHelper = new HttpRequestHelper();

    }

    public ArrayList<Forecast> getDailyForecast(String city, int days) throws HttpException {

        HashMap<String, String> params = new HashMap<>();
        params.put("q",city);
        params.put("units","metric");
        params.put("appid",API_KEY);
        params.put("cnt", days);

        String query = HttpRequestHelper.createQuery(params);

        String response = httpRequestHelper.getResponseFromUrl(API_URL + API_SERVICE + query);

        ArrayList<Forecast> forecasts;
        try {
            JSONObject responseJsonObject = new JSONObject(response);
            forecasts = JsonParser.parseForecasts(responseJsonObject);
            return forecasts;
        } catch (JSONException e) {
            throw new HttpException("La respuesta del servidor no es correcta");
        }

    }
}
