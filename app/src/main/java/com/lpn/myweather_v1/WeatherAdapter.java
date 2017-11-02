package com.lpn.myweather_v1;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;



import java.util.List;

/**
 * Created by Paul on 02.05.2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    private List<Main> weathers;

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView weather;
        TextView city;

        public ViewHolder(View itemView) {
            super(itemView);
            weather = (TextView) itemView.findViewById(R.id.temperature);
            city = (TextView) itemView.findViewById(R.id.city);
        }

    }

    public WeatherAdapter(List<Main> weathers) {
        this.weathers = weathers;
    }


    @Override
    public WeatherAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Main post_weather = weathers.get(position);
         holder.weather.setText(Html.fromHtml(post_weather.getTemp().toString()));

        holder.city.setText("Moscow");

    }

    public int getItemCount() {
        if (weathers == null) {
            return  0;
        }
        return weathers.size();
    }
}
