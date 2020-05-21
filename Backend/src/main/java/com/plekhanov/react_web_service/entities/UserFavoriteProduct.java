package com.plekhanov.react_web_service.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Связка {@link User} и понравившегося ему {@link Product}
 * Нужно чтобы реализовать отношение многие ко многим
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserFavoriteProduct")
@Table(name = "user_favorite_product")
public class UserFavoriteProduct {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @ToString.Exclude          // чтобы не было кругового вызова toString, Equals, HashCode ломбоком,
    @EqualsAndHashCode.Exclude // т.к. User и UserFavoriteProduct имеют двунаправленную связь
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "product_id")
    Product product;
}
