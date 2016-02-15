package com.example.cice.openweathermapjson;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by V on 14/2/16.
 */
public class ForecastViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.text_view_day) TextView textViewDay;
    @Bind(R.id.text_view_temp) TextView textViewTemp;
    @Bind(R.id.text_view_max_temp) TextView textViewMaxTemp;
    @Bind(R.id.text_view_min_temp) TextView textViewMinTemp;


    public ForecastViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Forecast forecast) {

        textViewDay.setText(forecast.getDateTime());
        textViewTemp.setText(String.format("%s ºC", forecast.getDayTemp()));
        textViewMaxTemp.setText(String.format("Max: %s ºC", forecast.getMaxTemp()));
        textViewMinTemp.setText(String.format("Min: %s ºC", forecast.getMinTemp()));
    }

}
