package com.plekhanov.react_web_service.model.exceptions;

public class WrongConfirmCodeException extends RuntimeException {
    //TODO добавить параметр

    public WrongConfirmCodeException() {
        super("Wrong confirm code");
    }

}
