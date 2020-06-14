package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Сервис для {@link User}
 */
@Validated
public interface UserService {

    User saveOrUpdate(@NotNull User user);

    User findById(int id);

    User findByEmail(@NotBlank String email);

    void addProductToBag(@NotNull Integer productId, @NotNull User user);

    void deleteProductFromBag(@NotNull Integer productId, @NotNull User user);

    void addProductToFavorite(@NotNull Integer productId, @NotNull User user);

    void deleteProductFromFavorite(@NotNull Integer productId, @NotNull User user);
}
