package com.plekhanov.react_web_service.entities;

import lombok.*;
import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Тип продукта
 */
@Data
@Entity(name = "ProductType")
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Enumerated(STRING)
    @Column(name = "category")
    private Category category;



    public enum Category {
        clothes,
        shoes,
        accessories
    }

}
