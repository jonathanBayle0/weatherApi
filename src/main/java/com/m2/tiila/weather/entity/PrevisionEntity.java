package com.m2.tiila.weather.entity;

import lombok.Data;

import java.time.Instant;

@Data
public class PrevisionEntity {

  private Instant date;
  private String city;
  private EnumPrevisionState state;
  private float temperature;


}
