package com.petrarca.apicardapio.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    private HttpStatus statusCode;

    public AppException(String message, HttpStatus statuscode) {
        super(message);
        this.statusCode = statuscode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

}
