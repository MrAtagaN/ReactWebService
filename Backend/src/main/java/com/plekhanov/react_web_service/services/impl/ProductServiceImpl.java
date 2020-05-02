package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.search_params.*;
import com.plekhanov.react_web_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Set;


@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;


    @Override
    public Product saveOrUpdate(@NotNull Product product) {
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
