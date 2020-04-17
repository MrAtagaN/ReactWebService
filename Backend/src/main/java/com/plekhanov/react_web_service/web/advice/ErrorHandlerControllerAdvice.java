package com.plekhanov.react_web_service.web.advice;

import com.plekhanov.react_web_service.web.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

import static com.plekhanov.react_web_service.web.dto.ApiResponse.ResponseCode.UNKNOWN_ERROR;
import static com.plekhanov.react_web_service.web.dto.ApiResponse.ResponseCode.VALIDATION_ERROR;

/**
 * Обработчик ошибок контроллеров
 */
@Slf4j
@ControllerAdvice
class ErrorHandlerControllerAdvice {


    /**
     * Обработка Exception
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResponse> onExceptionHandler(Exception e, WebRequest webRequest) {
        log.error("Internal error during handling request {} , {}.", e, webRequest);
        ApiResponse apiResponse = ApiResponse.error(UNKNOWN_ERROR, "Internal server error");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
    }

    /**
     * Обработка ошибок валидации javax.validation
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> validationEx(ConstraintViolationException e, WebRequest webRequest) {
        log.warn("Validation exception during handling request {} , {}.", e.getMessage(), webRequest);
        ApiResponse apiResponse = ApiResponse.error(VALIDATION_ERROR, "Validation error");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
    }
}
