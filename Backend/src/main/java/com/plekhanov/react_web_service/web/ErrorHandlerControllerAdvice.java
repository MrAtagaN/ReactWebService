package com.plekhanov.react_web_service.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;

import static com.plekhanov.react_web_service.web.ApiResponse.ResponseCode.*;

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
    public ResponseEntity<ApiResponse> onExceptionHandler(final Exception e, final WebRequest webRequest) {
        log.error("Internal error during handling request {} , {}.", e, webRequest);
        final ApiResponse apiResponse = ApiResponse.error(UNKNOWN_ERROR, "Internal server error");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
    }

    /**
     * Отсутствие обязательных входных параметров
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<ApiResponse> onMissingServletRequestParameterExceptionHandler(
            final MissingServletRequestParameterException e,
            final WebRequest webRequest) {

        final String missingParameter = e.getParameterName();
        log.error("MissingServletRequestParameter: {}, in request {}.", missingParameter, webRequest);
        final ApiResponse apiResponse =
                ApiResponse.error(VALIDATION_ERROR, "Missing mandatory request parameter: " + missingParameter);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
    }

    /**
     * Неверный тип входящего параметра
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ApiResponse> onMethodArgumentTypeMismatchExceptionHandler(
            final MethodArgumentTypeMismatchException e,
            final WebRequest webRequest) {

        final String invalidParameter = e.getName();
        log.error("MissingServletRequestParameter: {}, in request {}.", invalidParameter, webRequest);
        final ApiResponse apiResponse =
                ApiResponse.error(VALIDATION_ERROR, "Invalid type in request parameter: " + invalidParameter);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
    }

    /**
     * Отказ доступа
     */
    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiResponse> onAccessDeniedExceptionHandler(final Exception e, final WebRequest webRequest) {
        log.debug("Access denied during handling request {}.", webRequest);
        final ApiResponse apiResponse = ApiResponse.error(ACCESS_DENIED, "Access denied");
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
    }

    /**
     * Ошибока валидации javax.validation
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<?> validationException(final ConstraintViolationException e, final WebRequest webRequest) {
        log.warn("Validation exception during handling request {} , {}.", e.getMessage(), webRequest);
        final ApiResponse apiResponse = ApiResponse.error(VALIDATION_ERROR, "Validation error");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
    }
}
