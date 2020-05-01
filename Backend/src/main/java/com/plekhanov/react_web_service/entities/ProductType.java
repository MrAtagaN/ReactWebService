package com.plekhanov.react_web_service.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.FetchMode.SELECT;

/**
 * Тип продукта
 */

@Data
@Entity(name = "ProductType")
@Table(name = "product_type")
public class ProductType {

    public ProductType() {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Enumerated(STRING)
    @Column(name = "category")
    private Category category;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "type", cascade = ALL, orphanRemoval = true, fetch = LAZY)
    @Fetch(value=SELECT)
    private Set<Product> products;

    public enum Category {
        clothes,
        shoes,
        accessories
    }

}
