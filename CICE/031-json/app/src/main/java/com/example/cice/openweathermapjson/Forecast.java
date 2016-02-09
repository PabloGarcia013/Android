package com.example.cice.openweathermapjson;

/**
 * Created by CICE on 9/2/16.
 */
public class Forecast {

    String dateTime;
    String dateTemp, minTemp, maxTemp;
    String pressure, himidity;
    String text, description;
    String speed;

    public Forecast(String dateTime, String dateTemp, String minTemp, String maxTemp, String pressure, String himidity, String text, String description, String speed) {
        this.dateTime = dateTime;
        this.dateTemp = dateTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.pressure = pressure;
        this.himidity = himidity;
        this.text = text;
        this.description = description;
        this.speed = speed;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTemp() {
        return dateTemp;
    }

    public void setDateTemp(String dateTemp) {
        this.dateTemp = dateTemp;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHimidity() {
        return himidity;
    }

    public void setHimidity(String himidity) {
        this.himidity = himidity;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }
}
