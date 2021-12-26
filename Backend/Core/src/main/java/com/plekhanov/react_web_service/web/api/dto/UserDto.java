package com.plekhanov.react_web_service.web.api.dto;

import com.plekhanov.react_web_service.model.entities.Authority;
import com.plekhanov.react_web_service.model.entities.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * Dto для {@link User}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {//TODO выкинуть ненужные аннотации

    Integer id;
    String username;
    String email;
    LocalDateTime lastEnter;
    Map<ProductDto, Integer> bagProducts;
    Set<ProductDto> favoriteProducts;
    Set<Authority> authorities;

}
