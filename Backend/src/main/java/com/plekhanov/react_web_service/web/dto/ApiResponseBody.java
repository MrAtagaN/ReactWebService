package com.plekhanov.react_web_service.web.dto;

import lombok.Data;

@Data
public class ApiResponseBody<T> {

    private T data;
    private int code;
    private String errorMessage;
}
