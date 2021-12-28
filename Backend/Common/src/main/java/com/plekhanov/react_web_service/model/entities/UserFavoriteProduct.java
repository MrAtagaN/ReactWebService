package com.plekhanov.react_web_service.model.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Связка {@link User} и понравившегося ему {@link Product}
 * Нужно чтобы реализовать отношение многие ко многим
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity(name = "UserFavoriteProduct")
@Table(name = "user_favorite_product")
public class UserFavoriteProduct implements Serializable {

    // раньше был составной ключ из полей user и product,
    // но в таком случае hibernate при каскадном сохранении
    // user.getFavoriteProducts().add(new UserFavoriteProduct(user, products));
    //
    // сначала ищет объект в базе. И т.к. такого объекта нет, создает UserFavoriteProduct с null полями
    // т.к это первичные ключи
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    Product product;


    public UserFavoriteProduct(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    @Override
    public String toString() {
        return "UserFavoriteProduct{" +
                (user == null ? "user == null" : "user id: " + user.getId()) +
                ", " +
                (product == null ? "product == null" : "product id: " + product.getId()) +
                "}";
    }
}
