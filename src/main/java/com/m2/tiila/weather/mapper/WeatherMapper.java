package com.m2.tiila.weather.mapper;

import com.m2.tiila.weather.entity.PrevisionEntity;
import dto.openweather.Model200;
import dto.weatherapi.Prevision;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class WeatherMapper {
  public static PrevisionEntity toEntity(Model200 dto) {
    PrevisionEntity entity = new PrevisionEntity();
    entity.setTemperature(dto.getMain().getTemp().floatValue());
    entity.setCity(dto.getName());
    return entity;
  }

  public static Prevision toDto(PrevisionEntity entity) {
    Prevision dto = new Prevision();
    dto.setTemperature((int) entity.getTemperature());
    dto.setCity(entity.getCity());
    return dto;
  }
}
