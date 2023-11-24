package com.m2.tiila.weather.controller;

import jakarta.ws.rs.core.MediaType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import dto.weatherapi.City;

import java.awt.*;

import static io.restassured.RestAssured.given;

public class CityControllerTest extends ControllerTest {
  @Test
  @DisplayName("Test creation city then 200")
  public void testCreationCityOk() {
    var city = new City();
    city.setCountry("France");
    city.setId("132");
    city.setRegion("Finistere");
    city.setName("brest");
    city.setPosteCode(29200);

    given()
      .headers(headersMock())
      .contentType(MediaType.APPLICATION_JSON)
      .body(city)
      .post("/cities")
      .then()
      .statusCode(HttpStatus.SC_OK);
  }

@Test
  @DisplayName("Test creation city without header then 403")
  public void testCreationCityWithoutHeader() {
    var city = new City();
    city.setCountry("France");
    city.setId("132");
    city.setRegion("Finistere");
    city.setName("brest");
    city.setPosteCode(29200);

    given()
      .contentType(MediaType.APPLICATION_JSON)
      .body(city)
      .post("/cities")
      .then()
      .statusCode(HttpStatus.SC_FORBIDDEN);
  }
}
