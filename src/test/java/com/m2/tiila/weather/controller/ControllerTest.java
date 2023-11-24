package com.m2.tiila.weather.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST")
public class ControllerTest {
  @LocalServerPort
  protected int port;

  @BeforeAll
  public void setUp() {
    RestAssured.basePath = "/api/v1";
    RestAssured.port = port;
  }

  protected Map<String, String> headersMock() {
    Map<String, String> headers = new HashMap<>();
    headers.put("Authentication", "authentification");
    return headers;
  }
  protected Map<String, String> headerAdminMock() {
    Map<String, String> headers = new HashMap<>();
    headers.put("Authentication", "authentification");
    headers.put("user", "admin");
    return headers;
  }

}
