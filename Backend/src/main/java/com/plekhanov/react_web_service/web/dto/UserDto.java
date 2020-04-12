package com.plekhanov.react_web_service.web.dto;

import com.plekhanov.react_web_service.entities.User;
import lombok.Builder;
import lombok.Data;

/**
 * Dto для {@link User}
 */
@Data
@Builder
public class UserDto {

    private Integer id;
    private String username;

    /**
     * Фабричный метод. Возвращает {@link UserDto} из переданного {@link User}
     */
    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
