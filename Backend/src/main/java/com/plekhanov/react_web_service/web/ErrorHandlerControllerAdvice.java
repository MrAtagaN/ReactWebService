package com.plekhanov.react_web_service.web;

import com.plekhanov.react_web_service.model.exceptions.WrongConfirmCodeException;
import com.plekhanov.react_web_service.model.exceptions.UserEmailAlreadyExistException;
import com.plekhanov.react_web_service.model.exceptions.UserRequestNotFoundException;
import com.plekhanov.react_web_service.web.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import static com.plekhanov.react_web_service.web.api.ResponseCode.*;

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
    public ResponseEntity<ApiResponse<String>> onExceptionHandler(final Exception e, final WebRequest webRequest) {
        log.error("Internal error during handling request {} , {}.", e, webRequest);
        final ApiResponse<String> apiResponse = ApiResponse.error(UNKNOWN_ERROR, "Internal server error");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     * Обработка ValidationException
     */
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ApiResponse<String>> onValidationExceptionHandler(final ValidationException e, final WebRequest webRequest) {
        log.error("[VALIDATION] Validation exception during handling request {} , {}.", e, webRequest);
        final ApiResponse<String> apiResponse = ApiResponse.error(VALIDATION_ERROR, "Validation error");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }

    /**
     * Ошибка валидации javax.validation
     */
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ApiResponse<String>> validationException(final ConstraintViolationException e, final WebRequest webRequest) {
        log.error("[VALIDATION] Validation exception during handling request {} , {}.", e.getMessage(), webRequest);
        final ApiResponse<String> apiResponse = ApiResponse.error(VALIDATION_ERROR, "Validation error");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     * Отсутствие обязательных входных параметров
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResponseEntity<ApiResponse<String>> onMissingServletRequestParameterExceptionHandler(
            final MissingServletRequestParameterException e,
            final WebRequest webRequest) {

        final String missingParameter = e.getParameterName();
        log.debug("[VALIDATION] MissingServletRequestParameter: {}, in request {}.", missingParameter, webRequest);
        final ApiResponse<String> apiResponse =
                ApiResponse.error(VALIDATION_ERROR, "Missing mandatory request parameter: " + missingParameter);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     * Неверный тип входящего параметра
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ApiResponse<String>> onMethodArgumentTypeMismatchExceptionHandler(
            final MethodArgumentTypeMismatchException e,
            final WebRequest webRequest) {

        final String invalidParameter = e.getName();
        log.debug("[VALIDATION] MissingServletRequestParameter: {}, in request {}.", invalidParameter, webRequest);
        final ApiResponse<String> apiResponse =
                ApiResponse.error(VALIDATION_ERROR, "Invalid type in request parameter: " + invalidParameter);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     * Отказ доступа
     */
    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ApiResponse<String>> onAccessDeniedExceptionHandler(final Exception e, final WebRequest webRequest) {
        log.warn("[AUTHENTICATION] Access denied during handling request {}.", webRequest);
        final ApiResponse<String> apiResponse = ApiResponse.error(ACCESS_DENIED, "Access denied");
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     * Ошибка аутентификации
     */
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<ApiResponse<String>> onAuthenticationExceptionHandler(final Exception e, final WebRequest webRequest) {
        log.warn("[AUTHENTICATION] Authentication failure during handling request {}.", webRequest);
        final ApiResponse<String> apiResponse = ApiResponse.error(AUTHENTICATION_FAILURE, "Authentication failure");
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     *
     */
    @ExceptionHandler({WrongConfirmCodeException.class})
    public ResponseEntity<ApiResponse<String>> confirmCodeException(final WrongConfirmCodeException e) {
        log.warn("[REGISTRATION] {}", e.getMessage());
        final ApiResponse<String> apiResponse = ApiResponse.error(WRONG_CONFIRM_CODE, e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     *
     */
    @ExceptionHandler({UserEmailAlreadyExistException.class})
    public ResponseEntity<ApiResponse<String>> userEmailAlreadyExistException(final UserEmailAlreadyExistException e) {
        log.error("[REGISTRATION] {}", e.getMessage());
        final ApiResponse<String> apiResponse = ApiResponse.error(USER_EMAIL_ALREADY_EXIST, e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }


    /**
     *
     */
    @ExceptionHandler({UserRequestNotFoundException.class})
    public ResponseEntity<ApiResponse<String>> UserRequestTimeOutException(final UserRequestNotFoundException e) {
        log.error("[REGISTRATION] {}", e.getMessage());
        final ApiResponse<String> apiResponse = ApiResponse.error(USER_REQUEST_TIME_OUT, e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(apiResponse);
    }

}
