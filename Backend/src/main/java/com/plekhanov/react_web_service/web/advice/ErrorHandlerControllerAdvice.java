package com.plekhanov.react_web_service.web.advice;

import com.plekhanov.react_web_service.web.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static com.plekhanov.react_web_service.web.dto.ApiResponse.ResponseCode.UNKNOWN_ERROR;

@Slf4j
@ControllerAdvice
class ErrorHandlerControllerAdvice {


    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResponse> onExceptionHandler(Exception e, WebRequest webRequest) {
        log.error("Internal error during handling request {}.", webRequest, e);

        ApiResponse apiResponse = ApiResponse.error(UNKNOWN_ERROR, "Internal server error");

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(apiResponse);
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
