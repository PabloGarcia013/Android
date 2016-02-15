package com.example.cice.openweathermapjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by V on 15/2/16.
 */
public class ForecastWeatherFragment extends Fragment {

    private static final String ARG_FORECAST_CYTY = "forecast_city";
    private static final String ARG_WEATHER_CITIES = "weather_cities";

    private String forecastCity;
    private ArrayList<String> weatherCities;

    private Context context;

    ForecastRecyclerAdapter recyclerAdapter;

    @Bind(R.id.recycler_view) RecyclerView recyclerView;

    ApiManager apiManager;
    AsyncTask<String, Void, ArrayList<Forecast>> task;

    public static ForecastWeatherFragment newInstance(String forecastCity, ArrayList<String> weatherCities) {

        Bundle args = new Bundle();

        args.putString(ARG_FORECAST_CYTY,forecastCity);
        args.putStringArrayList(forecastCity,weatherCities);

        ForecastWeatherFragment fragment = new ForecastWeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();
        if(getArguments() != null){
            forecastCity = getArguments().getString(ARG_FORECAST_CYTY);
            weatherCities = getArguments().getStringArrayList(ARG_WEATHER_CITIES);
        }

        apiManager = ApiManager.getInstance(context);

        task = new ForecastTask();
        task.execute(forecastCity);
    }

    private void setupRecycler(){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerAdapter = new ForecastRecyclerAdapter(context);
        recyclerView.setAdapter(recyclerAdapter);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.recycler_view,container,false);
        ButterKnife.bind(this,layout);
        this.setupRecycler();
        return layout;
    }

    private class ForecastTask extends AsyncTask<String, Void, ArrayList<Forecast>> {

        ProgressDialog progressDialog;
        String error;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(context,"Cargando","espera");
        }

        @Override
        protected ArrayList<Forecast> doInBackground(String... params) {

            try {
                String forecastCity = params[0];
                return apiManager.getDailyForecast(forecastCity,7);
            } catch (HttpException e) {
                e.printStackTrace();
                error = e.getMessage();
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Forecast> forecasts) {
            super.onPostExecute(forecasts);
            progressDialog.dismiss();
            recyclerAdapter.setDataSet(forecasts);
        }
    }
}
