package com.m2.tiila.weather.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2.tiila.weather.repository.client.OpenWeatherClient;
import com.m2.tiila.weather.repository.interceptor.OpenWeatherInterceptor;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import jakarta.inject.Inject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Configuration
@Profile("!TEST")
public class FeignConfig {
  @Inject
  private OpenWeatherInterceptor openWeatherInterceptor;
    @Inject
    private ObjectMapper objectMapper;
  @Bean
  OpenWeatherClient getOpenWeatherClient() {
      return Feign.builder()
        .encoder(new JacksonEncoder(objectMapper))
        .decoder(new JacksonDecoder(objectMapper))
        .client(new OkHttpClient(getOkhttpClient()))
        .requestInterceptor(openWeatherInterceptor)
        .logger(new Logger.JavaLogger(FeignConfig.class))
        .logLevel(Logger.Level.FULL)
        .target(OpenWeatherClient.class, "https://api.openweathermap.org/");
  }

    private okhttp3.OkHttpClient getOkhttpClient() {
        var okhttpClient = new okhttp3.OkHttpClient().newBuilder();
        okhttpClient.connectTimeout(1000, TimeUnit.MILLISECONDS);
        okhttpClient.readTimeout(1000, TimeUnit.MILLISECONDS);
        return okhttpClient.build();
    }
}
