package com.m2.tiila.weather.repository;

import dto.weatherapi.City;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;

@Component
public class CityRepository {
    private final static String SQL_INSERT_CITY = "INSERT INTO CITIES (ID, NAME, REGION, COUNTRY, POSTE_CODE) VALUES (:id, :name, :region, :country, :posteCode)";
    private final static String SQL_DELETE_CITY = "DELETE FROM CITIES WHERE ID = :id";
    private final static String SQL_PUT_CITY = "UPDATE CITIES SET ID = :id, NAME = :name, REGION = :region, COUNTRY = :country, POSTE_CODE = :posteCode WHERE ID = :oldId";
    private final static String SQL_GET_ALL_CITIES = "SELECT * FROM CITIES";
    @Inject
    private NamedParameterJdbcTemplate jdbcTemplate;
    public void createCity(City city) {
        var params = new HashMap();

        params.put("id", city.getId());
        params.put("name", city.getName());
        params.put("region", city.getRegion());
        params.put("country", city.getCountry());
        params.put("posteCode", city.getPosteCode());

        this.jdbcTemplate.update(SQL_INSERT_CITY, params);
    }

    public void deleteCity(Integer id) {
        var params = new HashMap();
        params.put("id", id);

        this.jdbcTemplate.update(SQL_DELETE_CITY, params);
    }

    public List<City> getCity() {
        return this.jdbcTemplate.query(SQL_GET_ALL_CITIES, new BeanPropertyRowMapper(City.class));
    }

    public void putCity(Integer id, City city) {
        var params = new HashMap();

        params.put("oldId", id);
        params.put("id", city.getId());
        params.put("name", city.getName());
        params.put("region", city.getRegion());
        params.put("country", city.getCountry());
        params.put("posteCode", city.getPosteCode());

        this.jdbcTemplate.update(SQL_PUT_CITY, params);
    }
}
