package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductDao productDao;


    @Override
    public Product saveOrUpdate(final Product product) {
        log.info("Save or update product {}", product);
        return productDao.save(product);
    }


    @Override
    public List<Product> search(final ProductSearchParams productSearchParams) {
        PageRequest pageRequest = null;
        final Integer page = productSearchParams.getPage();
        final Integer itemsInPage = productSearchParams.getItemsInPage();

        if (page != null && itemsInPage != null) {
            pageRequest = PageRequest.of(page, itemsInPage);
        }
        return productDao.findByParameters(
                productSearchParams.getName(),
                productSearchParams.getTypeId(),
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
                pageRequest);
    }


    @Override
    public void deleteById(int id) {
        log.info("Delete product with id {}", id);
        productDao.deleteById(id);
    }

}
