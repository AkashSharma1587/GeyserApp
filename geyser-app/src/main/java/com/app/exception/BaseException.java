package com.app.exception;

import com.google.common.collect.Maps;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Map;

public class BaseException extends WebApplicationException {
    private int statusCode = 400;
    private String type;
    private String code;
    private String message;
    private Map<String, String> params = Maps.newHashMap();

    public BaseException(String code, String message) {
        this.code = code;
        this.message = message;
        this.type = "ERROR";
    }

    public BaseException(Response.Status statusCode, String code, String message) {
        this(code, message);
        this.statusCode = statusCode.getStatusCode();
    }

    public BaseException(Response.Status statusCode, String message) {
        this("", message);
        this.statusCode = statusCode.getStatusCode();
    }
}

