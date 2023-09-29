package com.m2.tiila.weather.exception;

public class FunctionalException extends RuntimeException {
    private String code;
    private String description;

    public FunctionalException(String code, String description) {
        super(description);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
