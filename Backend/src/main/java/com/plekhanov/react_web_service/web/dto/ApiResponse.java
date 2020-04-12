package com.plekhanov.react_web_service.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.plekhanov.react_web_service.web.dto.ApiResponse.ResponseCode.OK;

/**
 * Обертка ответа контроллера на rest запрос
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private T data;
    private int code;
    private String errorMessage;


    /**
     * Фабричный метод. Возвращает {@link ApiResponse} с кодом и сообщинием ошибки
     */
    public static ApiResponse error(ResponseCode code, String errorMessage) {
        return ApiResponse.builder()
                .code(code.getValue())
                .errorMessage(errorMessage)
                .build();
    }

    /**
     * Фабричный метод. Возвращает {@link ApiResponse} с кодом OK и данными
     */
    public static <T> ApiResponse<T> ok(T data) {
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
        UNKNOWN_ERROR(4);


        ResponseCode(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }
    }
}
