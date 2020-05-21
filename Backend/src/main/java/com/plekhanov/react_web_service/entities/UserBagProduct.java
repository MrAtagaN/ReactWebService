package com.plekhanov.react_web_service.entities;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Связка {@link User} и {@link Product} в его корзине
 * Нужно чтобы реализовать отношение многие ко многим
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "UserBagProduct")
@Table(name = "user_bag_product")
public class UserBagProduct {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @ToString.Exclude          // чтобы не было кругового вызова toString, Equals, HashCode ломбоком
    @EqualsAndHashCode.Exclude // т.к. User и UserBagProduct имеют двунаправленную связь
    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "product_id")
    Product product;
}
