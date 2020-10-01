package com.plekhanov.react_web_service.exceptions;

public class UserEmailAlreadyExist extends RuntimeException {

    public UserEmailAlreadyExist() {
        super();
    }

    public UserEmailAlreadyExist(String message) {
        super(message);
    }
}
