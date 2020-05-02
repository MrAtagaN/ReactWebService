package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Dao для {@link Product}
 */
@Validated
public interface ProductDao {

    Product findById(int id);

    Product saveOrUpdate(@NotNull Product product);

    /**
     * Возвращает Товары
     */
    Set<Product> search(ProductSearchParams productSearchParams);


}
