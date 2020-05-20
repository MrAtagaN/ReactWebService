package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductDao productDao;


    @Override
    public Product saveOrUpdate(final Product product) {
        return productDao.saveOrUpdate(product);
    }

    @Override
    public Set<Product> search(final ProductSearchParams productSearchParams) {
        return productDao.search(productSearchParams);
    }

    @Override
    public void delete(int id) {
        productDao.delete(id);
    }

}
