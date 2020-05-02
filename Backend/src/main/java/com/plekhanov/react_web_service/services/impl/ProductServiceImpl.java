package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserBagProduct;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.text.MessageFormat;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final UserDao userDao;

    @Override
    public Set<Product> search(ProductSearchParams productSearchParams) {
        return productDao.search(productSearchParams);
    }

    @Override
    public void addProductToBag(Integer productId, User user) {
        Product product = productDao.findById(productId);
        if (product == null) {
            throw new ValidationException(MessageFormat.format("No product with id: {0}", productId));
        }
        UserBagProduct userBagProduct = new UserBagProduct(null, user, product);
        user.getBagProducts().add(userBagProduct);
        userDao.saveOrUpdate(user);
    }
}
