package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Age;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductTypeServiceImpl implements ProductTypeService {

    ProductTypeDao productTypeDao;

    @Override
    public Set<ProductType> getAll() {
        return productTypeDao.getAll();
    }

    public ProductType findByParameters(final String name, Gender gender, final Age age, final Category category) {
        return productTypeDao.findByParameters(name, gender, age, category);
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
