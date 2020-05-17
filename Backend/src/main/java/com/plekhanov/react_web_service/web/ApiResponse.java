package com.plekhanov.react_web_service.web;

import lombok.*;

import static com.plekhanov.react_web_service.web.ApiResponse.ResponseCode.OK;

/**
 * Ответ контроллера на rest запрос
 */
@Value
@Builder
public class ApiResponse<T> {

    private T data;
    private int code;
    private String errorMessage;


    /**
     * Фабричный метод. Возвращает {@link ApiResponse} с кодом и сообщинием ошибки
     */
    public static ApiResponse error(final ResponseCode code, final String errorMessage) {
        return ApiResponse.builder()
                .code(code.getValue())
                .errorMessage(errorMessage)
                .build();
    }

    /**
     * Фабричный метод. Возвращает {@link ApiResponse} с кодом OK и данными
     */
    public static <T> ApiResponse<T> ok(final T data) {
        return ApiResponse.<T>builder()
                .code(OK.getValue())
                .data(data)
                .build();
    }


    public enum ResponseCode {
        OK(0),
        NOT_AUTHENTICATED(1),
        AUTHENTICATION_FAILURE(2),
        ACCESS_DENIED(3),
        UNKNOWN_ERROR(4),
        VALIDATION_ERROR(5);

        ResponseCode(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }
    }
}
