package com.plekhanov.react_web_service.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.FetchType.EAGER;

/**
 * Связка {@link User} и понравившегося ему {@link Product}
 * Нужно чтобы реализовать отношение многие ко многим
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserFavoriteProduct")
@Table(name = "user_favorite_product")
public class UserFavoriteProduct implements Serializable {

    @Id
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "user_id")
    User user;

    @Id
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "product_id")
    Product product;
}
