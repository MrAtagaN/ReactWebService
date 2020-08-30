package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductDao productDao;


    @Override
    public Product saveOrUpdate(final Product product) {
        return productDao.save(product);
    }

    @Override
    public List<Product> search(final ProductSearchParams productSearchParams) {
        return productDao.findByParameters(
                productSearchParams.getName(),
                productSearchParams.getTypeId(),
                productSearchParams.getSubType(),
                productSearchParams.getBrand(),
                productSearchParams.getPriceFrom(),
                productSearchParams.getPriceTo(),
                productSearchParams.getSizeFrom(),
                productSearchParams.getSizeTo(),
                productSearchParams.getNamedSize(),
                productSearchParams.getGender(),
                productSearchParams.getType(),
                productSearchParams.getAge(),
                productSearchParams.getColor(),
                productSearchParams.getIsNew(),
                productSearchParams.getIsSales(),
                PageRequest.of(productSearchParams.getPage(), productSearchParams.getItemsInPage()));
    }

    @Override
    public void deleteById(int id) {
        productDao.deleteById(id);
    }

}
