package com.plekhanov.react_web_service.entities;

import lombok.Data;
import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Связка {@link User} и {@link Product} в его корзине
 * Нужно чтобы реализовать отношение многие ко многим
 */
@Data
@Entity(name = "UserBagProduct")
@Table(name = "user_bag_product")
public class UserBagProduct {

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
