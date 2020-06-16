package com.plekhanov.react_web_service.entities;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Товар
 *
 * name - уникальное
 * type, price - обязательные
 */
@Data
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "type_id")
    ProductType type;

    @Column(name = "sub_type")
    String subType;

    @Column(name = "brand")
    String brand;

    @Column(name = "price")
    BigDecimal price;

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "value")
    Set<Integer> size = new HashSet<>();

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "named_size", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "name")
    Set<String> namedSize = new HashSet<>();

    @Enumerated(STRING)
    @Column(name = "gender")
    Gender gender;

    @Enumerated(STRING)
    @Column(name = "age")
    Age age;

    @Column(name = "color")
    String color;

    @Column(name = "is_new")
    Boolean isNew;

    @Column(name = "is_sales")
    Boolean isSales;

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "data")
    Set<byte[]> images = new HashSet<>();


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

}
