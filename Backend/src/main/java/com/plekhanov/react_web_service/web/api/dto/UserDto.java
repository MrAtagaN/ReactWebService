package com.plekhanov.react_web_service.web.api.dto;

import com.plekhanov.react_web_service.config.security.Authority;
import com.plekhanov.react_web_service.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

/**
 * Dto для {@link User}
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {//TODO выкинуть ненужные аннотации

    Integer id;
    String username;
    String email;
    LocalDateTime lastEnter;
    Map<ProductDto, Integer> bagProducts;
    Set<ProductDto> favoriteProducts;
    Set<Authority> authorities;

}
