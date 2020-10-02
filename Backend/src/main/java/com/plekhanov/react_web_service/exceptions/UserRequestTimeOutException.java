package com.plekhanov.react_web_service.exceptions;

public class UserRequestTimeOutException extends RuntimeException {

    public UserRequestTimeOutException() {
        super();
    }

    public UserRequestTimeOutException(String message) {
        super(message);
    }
}
