package com.m2.tiila.weather.business;

import com.m2.tiila.weather.entity.CityEntity;
import com.m2.tiila.weather.exception.FunctionalException;
import com.m2.tiila.weather.mapper.CityMapper;
import com.m2.tiila.weather.repository.CityRepository;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CityBusiness {
    @Inject
    private CityRepository cityRepository;
    public void createCity(CityEntity city) {
        if (city.getId() == null) throw new FunctionalException("ID_NULL", "L'ID de la city ne doit pas être null.");
        this.cityRepository.createCity(CityMapper.toDto(city));
    }

    public void deleteCity(Integer id) {
        this.cityRepository.deleteCity(id);
    }

    public List<City> getCity() {
        return this.cityRepository.getCity();
    }

    public void putCity(Integer id, CityEntity city) {
        this.cityRepository.putCity(id, CityMapper.toDto(city));
    }
}
