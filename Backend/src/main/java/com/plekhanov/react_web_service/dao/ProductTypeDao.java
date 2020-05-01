package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.ProductType;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

/**
 * Dao для {@link ProductType}
 */
@Validated
public interface ProductTypeDao {

    Set<ProductType> getAll();

}
