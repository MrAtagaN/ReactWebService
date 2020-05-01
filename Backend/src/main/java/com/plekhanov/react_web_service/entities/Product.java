package com.plekhanov.react_web_service.entities;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.FetchMode.SELECT;

/**
 * Товар
 */
@Data
@Entity(name = "Product")
@Table(name = "product")
@ToString(exclude = { "type" })
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

//    @Enumerated(STRING)
//    @Column(name = "category")
//    private Category category;

    @ManyToOne(fetch = EAGER)
    @JoinColumn(name = "type_id")
    @Fetch(SELECT)
    private ProductType type;

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
    @Column(name = "gender")
    private Gender gender;

    @Enumerated(STRING)
    @Column(name = "age")
    private Age age;

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



//    public enum Category {
//        clothes,
//        shoes,
//        accessories
//    }

    public enum Gender {
        male,
        female
    }

    public enum Age {
        adult,
        kids
    }

//    public enum Type {
//        jeans
//    }

}
