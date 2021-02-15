package com.plekhanov.react_web_service.exceptions;

public class UserEmailAlreadyExistException extends RuntimeException {

    //TODO добавить параметр email

    public UserEmailAlreadyExistException() {
        super("User with that email already exists");
    }

}
