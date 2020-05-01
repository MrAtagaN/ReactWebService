package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.*;
import com.plekhanov.react_web_service.infrastructure.search_params.ProductSearchParams;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Validated
public interface ProductDao {

    Product findById(int id);

    Integer save(@NotNull Product product);

//    /**
//     * Возвращает типы Товаров, по выбранным параметрам
//     */
//    Set<Type> getTypesByParameters(@NotNull Category category, Age age, Gender gender);

    /**
     * Возвращает Товары
     */
    Set<Product> search(ProductSearchParams productSearchParams);


}
