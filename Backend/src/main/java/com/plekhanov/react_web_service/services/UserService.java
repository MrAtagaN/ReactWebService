package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.User;

import javax.validation.constraints.NotNull;

public interface UserService {

    User findById(int id);

    void addProductToBag(@NotNull Integer productId, @NotNull User user);

    void deleteProductFromBag(@NotNull Integer productId, @NotNull User user);

    void addProductToFavorite(@NotNull Integer productId, @NotNull User user);

    void deleteProductFromFavorite(@NotNull Integer productId, @NotNull User user);
}
