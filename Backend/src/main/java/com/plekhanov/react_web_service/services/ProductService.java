package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Сервис для {@link Product}
 */
@Validated
public interface ProductService {

    Product saveOrUpdate(@NotNull Product product);

    void deleteById(int id);

    List<Product> search(@NotNull ProductSearchParams productSearchParams);

}
