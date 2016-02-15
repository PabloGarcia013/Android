package com.example.cice.openweathermapjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by CICE on 12/2/16.
 */
public class ForecastPagerFragment extends Fragment{

    private static final String ARG_FORECAST = "forecast";

    Context context;

    @Bind(R.id.text_view_day) TextView textViewDay;
    @Bind(R.id.text_view_temp) TextView textViewTemp;
    @Bind(R.id.text_view_max_temp) TextView textViewMaxTemp;
    @Bind(R.id.text_view_min_temp) TextView textViewMinTemp;

    private Forecast forecast;


    public static ForecastPagerFragment newInstance(Forecast forecast) {

        ForecastPagerFragment fragment = new ForecastPagerFragment();

        Bundle args = new Bundle();
        args.putParcelable(ARG_FORECAST, forecast);
        fragment.setArguments(args);

        return fragment;
    }

    public ForecastPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getContext();

        if (getArguments() != null) {
            forecast = getArguments().getParcelable(ARG_FORECAST);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.row_forecast, container, false);

        ButterKnife.bind(this, layout);

        textViewDay.setText(forecast.getDateTime());
        textViewTemp.setText(String.format("%s ºC", forecast.getDayTemp()));
        textViewMaxTemp.setText(String.format("Max: %s ºC", forecast.getMaxTemp()));
        textViewMinTemp.setText(String.format("Min: %s ºC", forecast.getMinTemp()));

        return layout;
    }

}
