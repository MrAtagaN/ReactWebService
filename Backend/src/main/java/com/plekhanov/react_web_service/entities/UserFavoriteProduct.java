package com.plekhanov.react_web_service.entities;

import lombok.Data;
import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Связка {@link User} и понравившегося ему {@link Product}
 * Нужно чтобы реализовать отношение многие ко многим
 */
@Data
@Entity(name = "UserFavoriteProduct")
@Table(name = "user_favorite_product")
public class UserFavoriteProduct {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
}
