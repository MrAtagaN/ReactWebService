package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserFavoriteProduct;
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


    /**
     * Получить текущего авторизованного пользователя
     */
    @Override
    public User getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            User user = (User) authentication.getPrincipal();
            return userDao.findById(user.getId()).get();
        }
        return null;
    }


    @Override
    public User findById(final int id) {
        return userDao.findById(id);
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


    /**
     * Удаляется из списка только один продукт
     */
    @Override
    public void deleteProductFromBag(final Integer productIdToDelete, final User user) {
        final Map<Product, Integer> bagProducts = user.getBagProducts();

        final Product productToRemove = new Product();
        productToRemove.setId(productIdToDelete);

        final Integer count = bagProducts.getOrDefault(productToRemove, 0);
        if (count <= 1) {
            bagProducts.remove(productToRemove);
        } else {
            bagProducts.put(productToRemove, count - 1);
        }

        userDao.save(user);
    }


    @Override
    public void addProductToFavorite(final Integer productId, final User user) {
        final Product product = productDao.findById(productId).orElseThrow(() ->
                new ValidationException(format("No product with id: {0}", productId)));
        Set<UserFavoriteProduct> favoriteProducts = user.getFavoriteProducts();
        favoriteProducts.add(new UserFavoriteProduct(user, product));
        userDao.save(user);
    }


    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void deleteProductFromFavorite(final Integer productId, final User user) {
        Set<UserFavoriteProduct> favoriteProducts = user.getFavoriteProducts();
        favoriteProducts.removeIf(userFavoriteProduct -> userFavoriteProduct.getProduct().getId().equals(productId));
        userDao.save(user);
    }


}
