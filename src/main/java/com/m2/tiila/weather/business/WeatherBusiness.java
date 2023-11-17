package com.m2.tiila.weather.business;

import com.m2.tiila.weather.entity.PrevisionEntity;
import com.m2.tiila.weather.exception.FunctionalException;
import com.m2.tiila.weather.mapper.WeatherMapper;
import com.m2.tiila.weather.repository.WeatherRepository;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import static com.m2.tiila.weather.mapper.WeatherMapper.toEntity;

@Component
public class WeatherBusiness {

  @Inject
  private WeatherRepository weatherRepository;
  @Inject
  private CityBusiness cityBusiness;

  public PrevisionEntity getCityWeather(String city, String user) {
    if (user.equals("admin"))
      return toEntity(weatherRepository.getCityWeather(city));
    var cities = cityBusiness.getCity();
    for (City c : cities) {
      if (c.getName().equals(city))
        return toEntity(weatherRepository.getCityWeather(city));
    }
    throw new FunctionalException("CITY_UNKNOW", "La ville n'existe pas dans la base de données");
  }
}
