package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.search_params.*;
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

    Set<Product> search(ProductSearchParams productSearchParams);


}
