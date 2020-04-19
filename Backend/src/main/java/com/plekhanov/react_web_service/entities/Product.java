package com.plekhanov.react_web_service.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Товар
 */
@Data
@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private String category;
    private String type;
    private String subType;
    private String producer;
    private BigDecimal price;
    private Integer size;
    private String namedSize;
    private Gender gender;
    private Age age;
    private String color;
    private Boolean isNew;
    private Boolean isSales;





    public enum Gender {
        MALE,
        FEMALE
    }

    public enum Age {
        ADULT,
        KIDS
    }

}
