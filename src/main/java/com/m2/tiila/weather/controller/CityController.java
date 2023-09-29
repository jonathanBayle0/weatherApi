package com.m2.tiila.weather.controller;

import com.m2.tiila.weather.business.CityBusiness;
import com.m2.tiila.weather.filter.AuthenticationRequired;
import com.m2.tiila.weather.mapper.CityMapper;
import dto.weatherapi.City;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

import java.awt.*;
import java.util.List;

@Controller
@Path("/cities")
public class CityController {

    @Inject
    private CityBusiness cityBusiness;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @AuthenticationRequired
    public Response createCity(City city) {
        cityBusiness.createCity(CityMapper.toEntity(city));
        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCity() {
        List<City> cities = cityBusiness.getCity();
        return Response.ok(cities).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCity(@PathParam("id") Integer id) {
        cityBusiness.deleteCity(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putCity(@PathParam("id") Integer id, City city) {
        cityBusiness.putCity(id, CityMapper.toEntity(city));
        return Response.ok().build();
    }
}
