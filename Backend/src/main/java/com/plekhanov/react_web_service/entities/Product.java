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

    private String name;
    private String description;
    private String category;
    private String type;
    private String subType;
    private String brand;
    private BigDecimal price;
    private Integer size;
    private String namedSize;
    private GenderCategory genderCategory;
    private AgeCategory ageCategory;
    private String color;
    private Boolean isNew;
    private Boolean isSales;
    private Set<byte[]> images;







    public enum GenderCategory {
        MALE,
        FEMALE
    }

    public enum AgeCategory {
        ADULT,
        KIDS
    }

}
