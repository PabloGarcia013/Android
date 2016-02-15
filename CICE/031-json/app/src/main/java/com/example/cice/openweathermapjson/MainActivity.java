package com.example.cice.openweathermapjson;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.frame_layout) FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Fragment forecastWeatherFragment = ForecastWeatherFragment.newInstance("Madrid,es", new ArrayList<String>());
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,forecastWeatherFragment).commit();

    }

}
