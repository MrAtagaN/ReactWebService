package com.plekhanov.react_web_service.web.dto;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserBagProduct;
import com.plekhanov.react_web_service.entities.UserFavoriteProduct;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Dto для {@link User}
 */
@Value
@Builder
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private LocalDateTime lastEnter;
    private List<Product> bagProducts;
    private Set<Product> favoriteProducts;

    /**
     * Фабричный метод. Возвращает {@link UserDto} из переданного {@link User}
     */
    public static UserDto fromUser(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .lastEnter(user.getLastEnter())
                .bagProducts(fromBagProducts(user.getBagProducts()))
                .favoriteProducts(fromFavoriteProducts(user.getFavoriteProducts()))
                .build();
    }

    /**
     * List<UserBagProduct> -> List<Product>
     */
    private static List<Product> fromBagProducts(List<UserBagProduct> userBagProducts) {
        return userBagProducts.stream().map(UserBagProduct::getProduct).collect(Collectors.toList());
    }

    /**
     * Set<UserFavoriteProduct> -> Set<Product>
     */
    private static Set<Product> fromFavoriteProducts(Set<UserFavoriteProduct> userFavoriteProducts) {
        return userFavoriteProducts.stream().map(UserFavoriteProduct::getProduct).collect(Collectors.toSet());
    }
}
