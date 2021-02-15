package com.plekhanov.react_web_service.exceptions;

public class WrongConfirmCodeException extends RuntimeException {

    public WrongConfirmCodeException() {
        super("Wrong confirm code");
    }

}
