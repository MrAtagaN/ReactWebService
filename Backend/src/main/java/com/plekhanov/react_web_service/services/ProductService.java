package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.search_params.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Validated
public interface ProductService {

    Product saveOrUpdate(@NotNull Product product);

    void delete(int id);

    Set<Product> search(@NotNull ProductSearchParams productSearchParams);

    void addProductToBag(@NotNull Integer productId, @NotNull User user);

    void deleteProductFromBag(@NotNull Integer productId, @NotNull User user);

    void addProductToFavorite(@NotNull Integer productId, @NotNull User user);

    void deleteProductFromFavorite(@NotNull Integer productId, @NotNull User user);
}
