package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.model.entities.ProductType;
import com.plekhanov.react_web_service.model.entities.ProductType.Category;
import com.plekhanov.react_web_service.model.entities.ProductType.Gender;
import com.plekhanov.react_web_service.model.entities.ProductType.Age;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductTypeServiceImpl implements ProductTypeService {

    ProductTypeDao productTypeDao;

    @Override
    public Set<ProductType> findByParameters(final String type, final Gender gender, final Age age, final Category category) {
        return productTypeDao.findByParameters(type, gender, age, category);
    }

    @Override
    public void deleteById(final int id) {
        log.info("[PRODUCT_TYPE] Delete productType with id {}", id);
        productTypeDao.deleteById(id);
    }

    @Override
    public ProductType saveOrUpdate(final ProductType productType) {
        log.info("[PRODUCT_TYPE] Save or update productType {}", productType);
        return productTypeDao.save(productType);
    }
}
