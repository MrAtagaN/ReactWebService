package com.plekhanov.react_web_service.exceptions;

public class UserEmailAlreadyExistException extends RuntimeException {

    public UserEmailAlreadyExistException() {
        super("User with that email already exists");
    }

}
