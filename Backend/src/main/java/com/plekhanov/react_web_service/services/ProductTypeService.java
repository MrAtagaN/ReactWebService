package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.ProductType;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Validated
public interface ProductTypeService {

    Set<ProductType> getAll();

    void delete(int id);

    ProductType saveOrUpdate(@NotNull ProductType productType);
}
