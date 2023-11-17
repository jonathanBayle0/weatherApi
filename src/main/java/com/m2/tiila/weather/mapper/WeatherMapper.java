package com.m2.tiila.weather.mapper;

import com.m2.tiila.weather.entity.PrevisionEntity;
import dto.openweather.Model200;
import dto.weatherapi.Prevision;

import java.time.Instant;

public class WeatherMapper {
  public static PrevisionEntity toEntity(Model200 dto) {
    PrevisionEntity entity = new PrevisionEntity();
    entity.setCity(dto.getName());
    return entity;
  }

  public static Prevision toDto(PrevisionEntity entity) {
    Prevision dto = new Prevision();
    dto.setCity(entity.getCity());
    return dto;
  }
}
