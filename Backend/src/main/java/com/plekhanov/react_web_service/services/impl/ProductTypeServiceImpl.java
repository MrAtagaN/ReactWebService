package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductTypeDao;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Age;
import com.plekhanov.react_web_service.entities.search_params.ProductTypeSearchParams;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Set;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductTypeServiceImpl implements ProductTypeService {

    ProductTypeDao productTypeDao;


    public ProductType findByParameters(final String name, Gender gender, final Age age, final Category category) {
        return productTypeDao.findByParameters(name, gender, age, category);
    }

    @Override
    public Set<ProductType> search(@NotNull final ProductTypeSearchParams productTypeSearchParams) {
        return productTypeDao.search(productTypeSearchParams);
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
