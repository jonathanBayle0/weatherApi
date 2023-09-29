package com.m2.tiila.weather.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Controller;

@Controller
@Path("/health")
public class HealthController {
    @GET
    public Response getHealth() {
        return Response.ok("Yeah I am fine :)").build();
    }
}

