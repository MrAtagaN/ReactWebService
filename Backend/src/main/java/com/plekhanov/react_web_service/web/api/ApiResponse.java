package com.plekhanov.react_web_service.web.api;

import lombok.*;

import static com.plekhanov.react_web_service.web.api.ApiResponse.ResponseCode.OK;

/**
 * Ответ контроллера на rest запрос
 */
@Value
@Builder
public class ApiResponse<T> {

    T data;
    int code;
    String errorMessage;


    /**
     * Фабричный метод. Возвращает {@link ApiResponse} с кодом и сообщинием ошибки
     */
    public static ApiResponse<String> error(final ResponseCode code, final String errorMessage) {
        return ApiResponse.<String>builder()
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
        VALIDATION_ERROR(5),
        WRONG_CONFIRM_CODE(6),
        USER_EMAIL_ALREADY_EXIST(7);

        ResponseCode(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }
    }
}
