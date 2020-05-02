package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserBagProduct;
import com.plekhanov.react_web_service.entities.UserFavoriteProduct;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.text.MessageFormat;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;
    private final UserDao userDao;

    @Override
    public Set<Product> search(final ProductSearchParams productSearchParams) {
        return productDao.search(productSearchParams);
    }

    @Override
    public void addProductToBag(final Integer productId, final User user) {
        Product product = productDao.findById(productId);
        if (product == null) {
            throw new ValidationException(MessageFormat.format("No product with id: {0}", productId));
        }
        final UserBagProduct userBagProduct = new UserBagProduct(null, user, product);
        user.getBagProducts().add(userBagProduct);
        userDao.saveOrUpdate(user);
    }

    @Override
    public void addProductToFavorite(final Integer productId, final User user) {
        final Product product = productDao.findById(productId);
        if (product == null) {
            throw new ValidationException(MessageFormat.format("No product with id: {0}", productId));
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
}
