package com.plekhanov.react_web_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * Товар
 */
@Data
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(STRING)
    @Column(name = "product_category")
    private ProductCategory productCategory;

    @Column(name = "type")
    private String type;

    @Column(name = "sub_type")
    private String subType;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "size")
    private Integer size;

    @Column(name = "named_size")
    private String namedSize;

    @Enumerated(STRING)
    @Column(name = "gender_category")
    private GenderCategory genderCategory;

    @Enumerated(STRING)
    @Column(name = "age_category")
    private AgeCategory ageCategory;

    @Column(name = "color")
    private String color;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "is_sales")
    private Boolean isSales;

    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "data")
    private Set<byte[]> images;



    public enum ProductCategory {
        CLOTHES,
        SHOES,
        ACCESSORIES
    }

    public enum GenderCategory {
        MALE,
        FEMALE
    }

    public enum AgeCategory {
        ADULT,
        KIDS
    }

}
