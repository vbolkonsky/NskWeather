package com.example.lehakorshun.nskweather.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lehakorshun.nskweather.ForecastActivity;
import com.example.lehakorshun.nskweather.R;
import com.example.lehakorshun.nskweather.helper.Helper;
import com.example.lehakorshun.nskweather.model.Forecast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<Forecast> items;
    private Context context;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.US);

    public WeatherAdapter(Context context) {
        this.context = context;
    }

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

        setForecastImage(holder, item.getPhenomena().getCloudiness());
        setForecastDate(holder, item.getYear(), item.getMonth(), item.getDay(), item.getHour());
        setForecastTemperature(holder, item.getTemperature().getMax(), item.getTemperature().getMin());
        setForecastWind(holder, item.getWind().getMax(), item.getWind().getMin());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.forecastItem)
        LinearLayout forecastItem;

        @Bind(R.id.forecastImage)
        ImageView forecastImage;

        @Bind(R.id.forecastDate)
        TextView forecastDate;

        @Bind(R.id.forecastTemperature)
        TextView forecastTemperature;

        @Bind(R.id.forecastWind)
        TextView forecastWind;

        @OnClick(R.id.forecastItem)
        public void onClick() {
            Intent intent = new Intent(context, ForecastActivity.class);
            intent.putExtra("forecast", items.get(getAdapterPosition()));
            context.startActivity(intent);
        }

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private void setForecastImage(ViewHolder holder, int cloudiness) {
        holder.forecastImage.setImageResource(Helper.getImage(cloudiness));
    }

    private void setForecastDate(ViewHolder holder, int year, int month, int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, 0);
        String date = dateFormat.format(calendar.getTime());
        holder.forecastDate.setText(date);
    }

    private void setForecastTemperature(ViewHolder holder, int max, int min) {
        String temperature = "Temperature: Max: " + max
                + " Min: " + min;
        holder.forecastTemperature.setText(temperature);
    }

    private void setForecastWind(ViewHolder holder, int max, int min) {
        String wind = "Wind: Max: " + max
                + " Min: " + min;
        holder.forecastWind.setText(wind);
    }
}
