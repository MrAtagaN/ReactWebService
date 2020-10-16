package com.plekhanov.react_web_service.exceptions;

public class UserEmailAlreadyExist extends RuntimeException {

    public UserEmailAlreadyExist() {
        super("User with that email already exists");
    }

}
