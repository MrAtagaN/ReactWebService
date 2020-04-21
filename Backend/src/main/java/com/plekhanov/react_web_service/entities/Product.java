package com.plekhanov.react_web_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Товар
 */
@Data
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ProductCategory category;

    @Column(name = "type")
    private String type;

    @Column(name = "subType")
    private String subType;

    @Column(name = "brand")
    private String brand;
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "size")
    private Integer size;

    @Column(name = "namedSize")
    private String namedSize;

    @Column(name = "genderCategory")
    private GenderCategory genderCategory;

    @Column(name = "ageCategory")
    private AgeCategory ageCategory;

    @Column(name = "color")
    private String color;

    @Column(name = "isNew")
    private Boolean isNew;

    @Column(name = "isSales")
    private Boolean isSales;

    @ElementCollection(fetch = FetchType.EAGER)
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
