package com.lpn.myweather_v1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Paul on 02.05.2017.
 */

public class Controller {
    static final String BASE_URL = "http://api.openweathermap.org/";

    public static OpenWeatherApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OpenWeatherApi openWeatherApi = retrofit.create(OpenWeatherApi.class);
        return openWeatherApi;
    }
}
