package com.plekhanov.react_web_service.web.dto;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserBagProduct;
import com.plekhanov.react_web_service.entities.UserFavoriteProduct;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Map<Product, Integer> bagProducts;
    Set<Product> favoriteProducts;

    /**
     * Фабричный метод. Возвращает {@link UserDto} из переданного {@link User}
     */
    public static UserDto fromUser(final User user) {
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
     * List<UserBagProductDao> -> Map<Product, Integer>
     */
    private static Map<Product, Integer> fromBagProducts(final List<UserBagProduct> userBagProducts) {
        List<Product> products = userBagProducts.stream()
                .map(UserBagProduct::getProduct)
                .collect(Collectors.toList());

        final Map<Product, Integer> map = new HashMap<>();
        products.forEach(product -> {
            if (map.containsKey(product)) {
                Integer count = map.get(product);
                map.put(product, ++count);
            } else {
                map.put(product, 1);
            }
        });
        return map;
    }

    /**
     * Set<UserFavoriteProduct> -> Set<Product>
     */
    private static Set<Product> fromFavoriteProducts(final Set<UserFavoriteProduct> userFavoriteProducts) {
        return userFavoriteProducts.stream()
                .map(UserFavoriteProduct::getProduct)
                .collect(Collectors.toSet());
    }
}
