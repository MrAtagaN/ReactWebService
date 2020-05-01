package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.ProductCategory;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Validated
public interface ProductDao {

    Product findById(int id);

    Integer save(@NotNull Product product);

    Set<String> getTypesByCategory(@NotNull ProductCategory productCategory);



}
