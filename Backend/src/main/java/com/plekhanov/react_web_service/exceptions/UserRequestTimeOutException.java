package com.plekhanov.react_web_service.exceptions;

public class UserRequestTimeOutException extends RuntimeException {

    public UserRequestTimeOutException() {
        super("User request not found, (time out)");
    }

}
