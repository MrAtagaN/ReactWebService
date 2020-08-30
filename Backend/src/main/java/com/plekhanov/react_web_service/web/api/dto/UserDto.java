package com.plekhanov.react_web_service.web.api.dto;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserFavoriteProduct;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Dto для {@link User}
 */
@Value
@Builder
public class UserDto {

    Integer id;
    String username;
    String email;
    LocalDateTime lastEnter;
    Map<ProductDto, Integer> bagProducts;
    Set<ProductDto> favoriteProducts;


    /**
     * Фабричный метод. Возвращает {@link UserDto} из переданного {@link User}
     */
    public static UserDto fromUser(final User user) {
        if (user == null) {
            return null;
        }
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
     * Map<Product, Integer> -> Map<ProductDto, Integer>
     */
    private static Map<ProductDto, Integer> fromBagProducts(final Map<Product, Integer> userBagProducts) {
        if (userBagProducts == null) {
            return null;
        }
        Map<ProductDto, Integer> result = new HashMap<>();
        userBagProducts.forEach((product, count) -> {
            result.put(ProductDto.fromProduct(product), count);
        });
        result.remove(null);
        return result;
    }


    /**
     * Set<Product> -> Set<ProductDto>
     */
    private static Set<ProductDto> fromFavoriteProducts(final Set<UserFavoriteProduct> userFavoriteProducts) {
        if (userFavoriteProducts == null) {
            return null;
        }
        return userFavoriteProducts.stream()
                .map(UserFavoriteProduct::getProduct)
                .map(ProductDto::fromProduct)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
}
