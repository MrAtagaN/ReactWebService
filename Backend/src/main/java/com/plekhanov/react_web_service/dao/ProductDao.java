package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.Product;

public interface ProductDao {

    Product findById(int id);

    void save(Product product);



}
