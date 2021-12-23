package com.plekhanov.react_web_service.model.exceptions;

public class UserRequestNotFoundException extends RuntimeException {

    public UserRequestNotFoundException() {
        super("User request not found");
    }

}
