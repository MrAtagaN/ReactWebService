package com.plekhanov.react_web_service.exceptions;

public class ConfirmCodeException extends RuntimeException {

    public ConfirmCodeException() {
        super();
    }

    public ConfirmCodeException(String message) {
        super(message);
    }
}
