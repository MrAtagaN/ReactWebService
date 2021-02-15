package com.plekhanov.react_web_service.exceptions;

public class WrongConfirmCodeException extends RuntimeException {
    //TODO добавить параметр

    public WrongConfirmCodeException() {
        super("Wrong confirm code");
    }

}
