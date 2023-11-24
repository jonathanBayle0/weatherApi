package com.m2.tiila.weather.controller;

import com.m2.tiila.weather.repository.client.OpenWeatherClient;
import dto.openweather.Main;
import dto.openweather.Model200;
import jakarta.inject.Inject;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class WeatherControllerTest extends ControllerTest {

  @Inject
  private OpenWeatherClient openWeatherClient;

  @Test
  @DisplayName("Test prevision then OK")
  public void testPrevision() {
    var model200 = new Model200();
    var main = new Main();
    main.setTemp(new BigDecimal(40));
    model200.setMain(main);
    model200.setName("brest");


    when(openWeatherClient.getWeather(any(), any())).thenReturn(model200);

    given()
      .headers(headerAdminMock())
      .get("/prevision/brest")
      .then()
      .statusCode(HttpStatus.SC_OK);
  }
}
