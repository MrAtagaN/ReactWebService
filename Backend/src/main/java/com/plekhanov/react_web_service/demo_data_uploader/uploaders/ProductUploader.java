package com.plekhanov.react_web_service.demo_data_uploader.uploaders;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.services.ProductTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

import static com.plekhanov.react_web_service.entities.Product.Age.adult;
import static com.plekhanov.react_web_service.entities.Product.Gender.male;
import static com.plekhanov.react_web_service.entities.ProductType.Category.clothes;

/**
 * Загрузка в базу {@link Product}
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductUploader {

    ProductService productService;
    ProductTypeService productTypeService;


    public void uploadData() {
        ProductType jeans = productTypeService.findByNameAndCategory("джинсы", clothes);

        //джинсы модель 123
        Set<Product> products = productService.search(ProductSearchParams.builder().name("модель 123").build());
        if (products.isEmpty()) {
            Product product = new Product();
            product.setName("модель 123");
            product.setDescription("джинсы классические, прямые");
            product.setType(jeans);
            product.setBrand("gap");
            product.setPrice(new BigDecimal(4999));
            product.setSize(32);
            product.setGender(male);
            product.setAge(adult);
            product.setColor("синие");
            productService.saveOrUpdate(product);
        }
    }
}
