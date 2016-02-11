package com.example.cice.openweathermapjson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by CICE on 9/2/16.
 */
public class JsonParser {

    public static ArrayList<Forecast> parseForecasts(JSONObject responseJsonObject) throws JSONException {
        ArrayList<Forecast> forecasts = new ArrayList<>();
        JSONArray forecastList = responseJsonObject.getJSONArray("list");
        for( int i = 0;i<forecastList.length(); i++){
            JSONObject forecastJsonObject = forecastList.getJSONObject(i);
            forecasts.add(parseForecast(forecastJsonObject));

        }
        return forecasts;
    }

    private static Forecast parseForecast(JSONObject forecastJsonObject) throws JSONException {

        Forecast forecast = new Forecast();

        String dateTime;
        String pressure;
        String speed;

        dateTime = forecastJsonObject.getString("dt");

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = dateFormat.parse(dateTime);
            forecast.setDateTime(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        pressure = forecastJsonObject.getString("pressure");
        speed = forecastJsonObject.getString("speed");

        forecast.setPressure(pressure);
        forecast.setSpeed(speed);

        JSONObject tempJsonObject = forecastJsonObject.getJSONObject("temp");
        parseTemp(forecast, tempJsonObject);

        JSONArray weatherJsonObject = forecastJsonObject.getJSONArray("weather");
        parseWeather(forecast,weatherJsonObject.getJSONObject(0));

        return forecast;
    }

    private static void parseTemp(Forecast forecast, JSONObject tempJsonObject) throws JSONException {

        String dayTemp, minTemp,maxTemp;

        dayTemp = tempJsonObject.getString("day");
        minTemp = tempJsonObject.getString("min");
        maxTemp = tempJsonObject.getString("max");

        forecast.setDayTemp(dayTemp);
        forecast.setMinTemp(minTemp);
        forecast.setMaxTemp(maxTemp);
    }

    private static void parseWeather(Forecast forecast, JSONObject weatherJsonObject) throws JSONException {

        forecast.setText(weatherJsonObject.getString("main"));
        forecast.setDescription(weatherJsonObject.getString("description"));

    }
}
