package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.*;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Сервис для {@link ProductType}
 */
@Validated
public interface ProductTypeService {

    ProductType saveOrUpdate(@NotNull ProductType productType);

    void deleteById(int id);

    Set<ProductType> findByParameters(String name, Gender gender, Age age, Category category);

}
