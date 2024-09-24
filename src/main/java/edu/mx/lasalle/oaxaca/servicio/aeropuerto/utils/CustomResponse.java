/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.lasalle.oaxaca.servicio.aeropuerto.utils;

import org.springframework.http.HttpStatus;

/**
 *
 * @author jonag
 */
public class CustomResponse {
    private HttpStatus httpCode;
    private Object data;
    private Object message;
    private int code;

    public CustomResponse() {
    }

    public CustomResponse(HttpStatus httpCode, Object data, Object message, int code) {
        this.httpCode = httpCode;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(HttpStatus httpCode) {
        this.httpCode = httpCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    
}

