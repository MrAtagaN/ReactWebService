package com.plekhanov.react_web_service.model.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Тип продукта
 *
 * Комбинация name, gender, age, category,  полей должна быть уникальной
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "ProductType")
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "type")
    String type;

    @Enumerated(STRING)
    @Column(name = "gender")
    Gender gender;

    @Enumerated(STRING)
    @Column(name = "age")
    Age age;

    @Enumerated(STRING)
    @Column(name = "category")
    Category category;


    public enum Gender {
        male,
        female,
        any
    }

    public enum Age {
        adult,
        kids,
        any
    }

    public enum Category {
        clothes,
        shoes,
        accessories
    }

}
