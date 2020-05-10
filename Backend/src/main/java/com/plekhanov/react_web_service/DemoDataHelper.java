package com.plekhanov.react_web_service;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.services.ProductTypeService;
import com.plekhanov.react_web_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.plekhanov.react_web_service.entities.Product.Age.adult;
import static com.plekhanov.react_web_service.entities.Product.Gender.male;
import static com.plekhanov.react_web_service.entities.ProductType.Category.clothes;
import static com.plekhanov.react_web_service.web.security.Role.ADMIN;
import static com.plekhanov.react_web_service.web.security.Role.USER;
import static java.util.Collections.singleton;

/**
 * Наполнение базы демонстрационными данными
 */
@Service
@RequiredArgsConstructor
public class DemoDataHelper {

    private final UserService userService;
    private final ProductTypeService productTypeService;
    private final ProductService productService;


    public void insertData() {
        System.setProperty("file.encoding", "UTF-8");

        //User
        User admin = userService.findByEmail("admin@gmail.com");
        if (admin == null) {
            admin = new User();
            admin.setUsername("Сергей");
            admin.setPassword("$2a$10$nWq3jS4Xui7hMVz4L1dUVuRYzY8DQsfWUROmXA627yd.wjm/FrD5G"); //admin
            admin.setAuthorities(singleton(ADMIN));
            admin.setAccountNonExpired(true);
            admin.setAccountNonLocked(true);
            admin.setCredentialsNonExpired(true);
            admin.setEnabled(true);
            admin.setEnter(LocalDateTime.of(2019,11,10,9,12));
            admin.setCreationTime(LocalDateTime.of(1989,12,24,9,12));
            admin.setEmail("admin@gmail.com");
            userService.saveOrUpdate(admin);
        }

        User user = userService.findByEmail("user@gmail.com");
        if (user == null) {
            user = new User();
            user.setUsername("Александр");
            user.setPassword("$2a$10$DPPNZFtJEqmVr8qpARZfvu4HbT2Sd1bj563TIgZ35A7JPVtZUZ5MG"); //user
            user.setAuthorities(singleton(USER));
            user.setAccountNonExpired(true);
            user.setAccountNonLocked(true);
            user.setCredentialsNonExpired(true);
            user.setEnabled(true);
            user.setEnter(LocalDateTime.of(2019,12,24,9,12));
            user.setCreationTime(LocalDateTime.of(1989,12,24,9,12));
            user.setEmail("user@gmail.com");
            userService.saveOrUpdate(user);
        }


        //ProductType
        ProductType productType = productTypeService.findByNameAndCategory("джинсы", clothes);
        if (productType == null) {
            productType = new ProductType();
            productType.setName("джинсы");
            productType.setCategory(clothes);
            productTypeService.saveOrUpdate(productType);
        }

        ProductType productType2 = productTypeService.findByNameAndCategory("рубашки", clothes);
        if (productType2 == null) {
            productType2 = new ProductType();
            productType2.setName("рубашки");
            productType2.setCategory(clothes);
            productTypeService.saveOrUpdate(productType2);
        }

        ProductType productType3 = productTypeService.findByNameAndCategory("футболки", clothes);
        if (productType3 == null) {
            productType3 = new ProductType();
            productType3.setName("футболки");
            productType3.setCategory(clothes);
            productTypeService.saveOrUpdate(productType3);
        }


        //Product
        Set<Product> products = productService.search(ProductSearchParams.builder().name("модель 123").build());
        if (products.isEmpty()) {
            Product product = new Product();
            product.setName("модель 123");
            product.setDescription("джинсы классические, прямые");
            product.setType(productType);
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
