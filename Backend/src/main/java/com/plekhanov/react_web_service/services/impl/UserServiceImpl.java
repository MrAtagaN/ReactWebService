package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserBagProduct;
import com.plekhanov.react_web_service.entities.UserFavoriteProduct;
import com.plekhanov.react_web_service.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.text.MessageFormat.format;


@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final ProductDao productDao;
    private final UserDao userDao;


    @Override
    public User findById(final int id) {
        return userDao.findById(id);
    }


    @Override
    public User saveOrUpdate(User user) {
        return userDao.saveOrUpdate(user);
    }


    @Override
    public void addProductToBag(final Integer productId, final User user) {
        final Product product = productDao.findById(productId);
        if (product == null) {
            throw new ValidationException(format("No product with id: {0}", productId));
        }
        final UserBagProduct userBagProduct = new UserBagProduct(null, user, product);
        user.getBagProducts().add(userBagProduct);
        userDao.saveOrUpdate(user);
    }


    @Override
    public void deleteProductFromBag(final Integer productId, final User user) {
        final List<UserBagProduct> bagProducts = user.getBagProducts();
        int index = -1;
        for (int i = 0; i < bagProducts.size(); i++) {
            final Product product = bagProducts.get(i).getProduct();
            if (product.getId().equals(productId)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            bagProducts.remove(index);
        }
        userDao.saveOrUpdate(user);
    }


    @Override
    public void addProductToFavorite(final Integer productId, final User user) {
        final Product product = productDao.findById(productId);
        if (product == null) {
            throw new ValidationException(format("No product with id: {0}", productId));
        }

        final Set<Integer> productIds = user.getFavoriteProducts().stream()
                .map(userFavoriteProduct -> userFavoriteProduct.getProduct().getId())
                .collect(Collectors.toSet());

        if (!productIds.contains(productId)) {
            final UserFavoriteProduct userFavoriteProduct = new UserFavoriteProduct(null, user, product);
            user.getFavoriteProducts().add(userFavoriteProduct);
            userDao.saveOrUpdate(user);
        }
    }


    @Override
    public void deleteProductFromFavorite(final Integer productId, final User user) {
        final Set<UserFavoriteProduct> favoriteProducts = user.getFavoriteProducts();
        UserFavoriteProduct toDelete = null;
        for (UserFavoriteProduct favoriteProduct : favoriteProducts) {
            final Product product = favoriteProduct.getProduct();
            if (product.getId().equals(productId)) {
                toDelete = favoriteProduct;
                break;
            }
        }
        if (toDelete != null) {
            favoriteProducts.remove(toDelete);
        }
        userDao.saveOrUpdate(user);
    }
}
