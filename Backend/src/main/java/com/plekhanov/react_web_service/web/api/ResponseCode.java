package com.plekhanov.react_web_service.web.api;

/**
 * //TODO
 */
public enum  ResponseCode {

    OK(0),
    NOT_AUTHENTICATED(1),
    AUTHENTICATION_FAILURE(2),
    ACCESS_DENIED(3),
    UNKNOWN_ERROR(4),
    VALIDATION_ERROR(5),
    WRONG_CONFIRM_CODE(6),
    USER_EMAIL_ALREADY_EXIST(7),
    USER_REQUEST_TIME_OUT(8);

    private final int value;

    ResponseCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
