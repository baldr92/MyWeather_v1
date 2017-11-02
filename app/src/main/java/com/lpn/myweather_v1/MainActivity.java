package com.lpn.myweather_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static OpenWeatherApi openWeatherApi;
    RecyclerView recyclerView;
    List<Main> weatherList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openWeatherApi = Controller.getApi();
        weatherList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.posts_weather);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        WeatherAdapter adapter = new WeatherAdapter(weatherList);
        recyclerView.setAdapter(adapter);

        openWeatherApi.getData(524901, "667c1922a3bd2d215dc5892db0b5e039").enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                weatherList.add(response.body().getMain());
                recyclerView.getAdapter().notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

//test