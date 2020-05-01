package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.ProductCategory;
import com.plekhanov.react_web_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    @Override
    public Set<String> getTypesByCategory(ProductCategory productCategory) {
        return productDao.getTypesByCategory(productCategory);
    }
}
