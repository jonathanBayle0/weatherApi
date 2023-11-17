package com.m2.tiila.weather.repository.client;

import dto.openweather.Model200;
import feign.Param;
import feign.RequestLine;

public interface OpenWeatherClient {
    @RequestLine("GET /data/2.5/weather?q={cityName}&units=metric&appid={token}")
    Model200 getWeather(
            @Param("cityName") String cityName,
            @Param("token") String token
    );
}
