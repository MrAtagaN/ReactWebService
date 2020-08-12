package com.plekhanov.react_web_service.entities;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Товар
 *
 * name - уникальное, обязательное
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
    @JoinColumn(name = "type_id", nullable = false)
    ProductType type;

    @Column(name = "sub_type")
    String subType;

    @Column(name = "brand")
    String brand;

    @Column(name = "price", nullable = false)
    BigDecimal price;

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "sizes", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "value")
    Set<Integer> size = new HashSet<>();

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "named_size", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "name")
    Set<String> namedSize = new HashSet<>();

    @Column(name = "color")
    String color;

    @Column(name = "is_new")
    Boolean isNew;

    @Column(name = "is_sales")
    Boolean isSales;

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "data")
    @OrderColumn
    List<byte[]> images = new ArrayList<>();

    @Column(name = "main_image")
    Integer mainImage; //номер в списке images


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
