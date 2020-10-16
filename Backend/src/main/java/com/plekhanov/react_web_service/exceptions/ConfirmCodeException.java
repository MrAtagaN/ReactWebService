package com.plekhanov.react_web_service.exceptions;

public class ConfirmCodeException extends RuntimeException {

    public ConfirmCodeException() {
        super("Wrong confirm code");
    }

}
