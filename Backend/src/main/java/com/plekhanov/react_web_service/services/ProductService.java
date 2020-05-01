package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.infrastructure.search_params.ProductSearchParams;
import java.util.Set;

public interface ProductService {

    /**
     * Возвращает Товары
     */
    Set<Product> search(ProductSearchParams productSearchParams);
}
