package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.Product.Category;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;

import java.util.Set;

public interface ProductService {

    /**
     * Возвращает типы Товаров, по выбранным параметрам
     */
    Set<String> getTypesByParameters(Category category, Age age, Gender gender);
}
