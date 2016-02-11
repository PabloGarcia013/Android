package com.example.cice.openweathermapjson;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiManager = new ApiManager();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    apiManager.getDailyForecast("Madrid,es",7);
                } catch (HttpException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private class ForecastTask extends AsyncTask<String, Void, ArrayList<Forecast>>{

        ProgressDialog progressDialog;
        String error;

        @Override
        protected ArrayList<Forecast> doInBackground(String... params) {
            return null;
            try {
                return apiManager.getDailyForecast("Madrid,es",7);
            } catch (HttpException e) {
                e.printStackTrace();
                error = e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Forecast> forecasts) {
            super.onPostExecute(forecasts);
            progressDialog = ProgressDialog.show(MainActivity.this,"Cargando","espera");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.dismiss();
        }
    }
}
