package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.ProductType;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Сервис для {@link ProductType}
 */
@Validated
public interface ProductTypeService {

    ProductType saveOrUpdate(@NotNull ProductType productType);

    void delete(int id);

    Set<ProductType> findByCategory(@NotNull ProductType.Category category);

    ProductType findByNameAndCategory(@NotNull String name, @NotNull ProductType.Category category);

    Set<ProductType> getAll();

}
