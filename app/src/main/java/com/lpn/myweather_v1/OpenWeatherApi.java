package com.lpn.myweather_v1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.util.List;
import com.lpn.myweather_v1.Weather;

/**
 * Created by Paul on 01.05.2017.
 */

public interface OpenWeatherApi {

    @GET("/data/2.5/weather?")
    Call<WeatherData> getData(@Query("id") int cityName, @Query("appid") String appid);
}
