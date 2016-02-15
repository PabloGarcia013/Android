package com.example.cice.openweathermapjson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by V on 14/2/16.
 */
public class ForecastRecyclerAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    ArrayList<Forecast> forecasts;
    Context context;

    public ForecastRecyclerAdapter(Context context) {
        this.forecasts = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.row_forecast,parent);
        return new ForecastViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        holder.bind(forecasts.get(position));
    }


    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public void setDataSet(ArrayList<Forecast> forecasts){
        this.forecasts = forecasts;
        notifyDataSetChanged();
    }
}
