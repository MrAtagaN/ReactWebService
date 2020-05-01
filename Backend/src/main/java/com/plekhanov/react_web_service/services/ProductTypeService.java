package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.entities.ProductType;

import java.util.Set;

public interface ProductTypeService {

    Set<ProductType> getAll();
}
