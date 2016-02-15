package com.example.cice.openweathermapjson;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ForecastWeatherFragment forecastWeatherFragment = ForecastWeatherFragment.newInstance("Madrid,es", new ArrayList<String>());

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, forecastWeatherFragment).commit();

    }


}
