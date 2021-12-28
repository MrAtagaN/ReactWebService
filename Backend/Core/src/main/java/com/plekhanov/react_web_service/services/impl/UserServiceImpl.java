package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.model.entities.Product;
import com.plekhanov.react_web_service.model.entities.User;
import com.plekhanov.react_web_service.model.entities.UserFavoriteProduct;
import com.plekhanov.react_web_service.services.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.util.*;

import static java.text.MessageFormat.format;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    ProductDao productDao;
    UserDao userDao;


    @Override
    public User getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            return findById(user.getId()); //получаем актуальное состояние из базы
        }
        return null;
    }


    @Override
    public User findById(final int id) {
        return userDao.findById(id).orElseThrow(() ->
                new RuntimeException(format("No User with id: {0}", id)));
    }

    @Override
    public User findByEmail(final String email) {
        return userDao.findByEmail(email);
    }


    @Override
    public User saveOrUpdate(final User user) {
        return userDao.save(user);
    }


    @Override
    public void addProductToBag(final Integer productId, final User user) {
        Product product = productDao.findById(productId).orElseThrow(() ->
                new ValidationException(format("No product with id: {0}", productId)));
        Map<Product, Integer> bagProducts = user.getBagProducts();
        Integer count = bagProducts.getOrDefault(product, 0);
        bagProducts.put(product, ++count);
        userDao.save(user);
    }


    @Override
    public void deleteProductFromBag(final Integer productIdToDelete, final User user) {
        final Map<Product, Integer> bagProducts = user.getBagProducts();
        Product productToDelete = null;
        int count = 0;

        for (Map.Entry<Product, Integer> entry : bagProducts.entrySet()) {
            Product product = entry.getKey();
            if (productIdToDelete.equals(product.getId())) {
                productToDelete = product;
                count = entry.getValue();
            }
        }

        if (count <= 1) {
            bagProducts.remove(productToDelete);
        } else {
            bagProducts.put(productToDelete, count - 1);
        }

        userDao.save(user);
    }



    @Override
    public void addProductToFavorite(final Integer productId, final User user) {
        final Product product = productDao.findById(productId).orElseThrow(() ->
                new ValidationException(format("No product with id: {0}", productId)));
        Set<UserFavoriteProduct> favoriteProducts = user.getFavoriteProducts();
        favoriteProducts.add(new UserFavoriteProduct(user, product)); //TODO запись в базе null, null. Разобраться
        userDao.saveAndFlush(user);
    }


    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void deleteProductFromFavorite(final Integer productId, final User user) {
        Set<UserFavoriteProduct> favoriteProducts = user.getFavoriteProducts();
        favoriteProducts.removeIf(userFavoriteProduct -> userFavoriteProduct.getProduct().getId().equals(productId));
        userDao.save(user);
    }


}
