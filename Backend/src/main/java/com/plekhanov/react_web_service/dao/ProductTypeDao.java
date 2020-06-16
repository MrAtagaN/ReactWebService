package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Age;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Dao для {@link ProductType}
 */
@Validated
public interface ProductTypeDao {

    Set<ProductType> getAll();

    ProductType findByParameters(@NotNull String name,
                                 @NotNull Gender gender,
                                 @NotNull Age age,
                                 @NotNull Category category);

    Set<ProductType> findByCategory(@NotNull Category category);

    void delete(int id);

    ProductType saveOrUpdate(@NotNull ProductType productType);

}
