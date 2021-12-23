package com.plekhanov.react_web_service.mapper;

import com.plekhanov.react_web_service.model.entities.UserFavoriteProduct;
import com.plekhanov.react_web_service.web.api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * //TODO
 */
@Component
@RequiredArgsConstructor
public class FavoriteProductMapper {

    private final ProductMapper productMapper;

    Set<ProductDto> fromFavoriteProducts(final Set<UserFavoriteProduct> userFavoriteProducts) {
        if (userFavoriteProducts == null) {
            return null;
        }
        return userFavoriteProducts.stream()
                .map(UserFavoriteProduct::getProduct)
                .map(productMapper::productToProductDto)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }
}
