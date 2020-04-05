package com.plekhanov.react_web_service.web.dto;

import lombok.Data;

@Data
public class ApiResponseBody<T> {

    private T data;
    private int code;
    private String errorMessage;


    public enum ResponseCode {

        OK(0),
        NOT_AUTHENTICATED(1),
        AUTHENTICATION_FAILURE(2),
        ACCESS_DENIED(3),
        UNKNOWN_ERROR(4);



        ResponseCode(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }
    }
}
