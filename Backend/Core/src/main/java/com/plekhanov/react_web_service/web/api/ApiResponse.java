package com.plekhanov.react_web_service.web.api;


import lombok.*;

import static com.plekhanov.react_web_service.web.api.ResponseCode.OK;

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

}
