package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.Product.ProductCategory;

import java.util.Set;

public interface ProductService {

    /**
     * Возвращает типы Товара, выбранной категории
     */
    Set<String> getTypesByCategory(ProductCategory productCategory);
}
