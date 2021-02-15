package com.plekhanov.react_web_service.exceptions;

public class UserRequestNotFoundException extends RuntimeException {

    public UserRequestNotFoundException() {
        super("User request not found");
    }

}
