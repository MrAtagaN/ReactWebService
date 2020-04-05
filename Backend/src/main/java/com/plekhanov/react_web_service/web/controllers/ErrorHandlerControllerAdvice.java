package com.plekhanov.react_web_service.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
class ErrorHandlerControllerAdvice {


    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> onExceptionHandler(Exception e, WebRequest webRequest) {
        log.error("Internal error during handling request {}.", webRequest, e);
        e.printStackTrace();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body("Internal server error");
    }

//    @ExceptionHandler({ValidationRequestException.class})
//    public ResponseEntity<?> validationEx(ValidationRequestException e, WebRequest webRequest) {
//
//        log.warn("Validation exception during handling request {} , {}.", e.getMessage(), webRequest);
//        if (e.getLocalizedErrorMessage() != null) {
//            return ResponseEntity.ok(Response.errorResponse(e.getLocalizedErrorMessage()));
//        }
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .header("Content-Type", "text/plain; charset=UTF-8")
//                .body("Bad request");
//    }
}
