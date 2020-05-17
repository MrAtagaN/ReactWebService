package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeDao productTypeDao;

    @Override
    public Set<ProductType> getAll() {
        return productTypeDao.getAll();
    }

    public ProductType findByNameAndCategory(final String name, final Category category) {
        return productTypeDao.findByNameAndCategory(name, category);
    }

    @Override
    public Set<ProductType> findByCategory(final Category category) {
        return productTypeDao.findByCategory(category);
    }

    @Override
    public void delete(final int id) {
        productTypeDao.delete(id);
    }

    @Override
    public ProductType saveOrUpdate(final ProductType productType) {
        return productTypeDao.saveOrUpdate(productType);
    }
}
