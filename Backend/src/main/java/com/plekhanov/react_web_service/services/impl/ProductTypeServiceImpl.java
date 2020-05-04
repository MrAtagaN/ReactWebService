package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeDao productTypeDao;

    @Override
    public Set<ProductType> getAll() {
        return productTypeDao.getAll();
    }

    @Override
    public void delete(int id) {
        productTypeDao.delete(id);
    }

    @Override
    public ProductType saveOrUpdate(ProductType productType) {
        return productTypeDao.saveOrUpdate(productType);
    }
}
