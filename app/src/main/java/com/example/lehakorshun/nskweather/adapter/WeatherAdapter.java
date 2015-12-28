package com.example.lehakorshun.nskweather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lehakorshun.nskweather.R;
import com.example.lehakorshun.nskweather.model.Forecast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<Forecast> items;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.US);

    public void setItems(List<Forecast> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent,
                false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Forecast item = items.get(position);

        Calendar calendar = Calendar.getInstance();
        calendar.set(item.getYear(), item.getMonth(), item.getDay(), item.getHour(), 0);
        String date = dateFormat.format(calendar.getTime());
        holder.forecastDate.setText(date);

        String temperature = "Max: " + item.getTemperature().getMax()
                + "Min: " + item.getTemperature().getMin();
        holder.forecastTemperature.setText(temperature);

        String wind = "Max: " + item.getWind().getMax()
                + "Min: " + item.getWind().getMin();
        holder.forecastWind.setText(wind);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.forecastDate)
        TextView forecastDate;

        @Bind(R.id.forecastTemperature)
        TextView forecastTemperature;

        @Bind(R.id.forecastWind)
        TextView forecastWind;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
