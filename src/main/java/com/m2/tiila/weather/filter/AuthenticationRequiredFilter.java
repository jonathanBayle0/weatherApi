package com.m2.tiila.weather.filter;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@AuthenticationRequired
@Provider
public class AuthenticationRequiredFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getHeaders().get("Authentication") == null) {
            requestContext.abortWith(Response.status(403).build());
        }
    }
}
