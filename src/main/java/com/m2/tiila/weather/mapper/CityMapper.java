package com.m2.tiila.weather.mapper;

import com.m2.tiila.weather.entity.CityEntity;
import dto.weatherapi.City;

public class CityMapper {
    public static City toDto(CityEntity cityEntity) {
        City dto = new City();

        dto.setId(cityEntity.getId());
        dto.setName(cityEntity.getName());
        dto.setRegion(cityEntity.getRegion());
        dto.setCountry(cityEntity.getCountry());
        dto.setPosteCode(cityEntity.getPosteCode());

        return dto;
    }

    public static CityEntity toEntity(City city) {
        CityEntity cityEntity = new CityEntity();

        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());
        cityEntity.setRegion(city.getRegion());
        cityEntity.setCountry(city.getCountry());
        cityEntity.setPosteCode(city.getPosteCode());

        return cityEntity;
    }
}


