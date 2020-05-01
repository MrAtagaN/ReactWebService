package com.plekhanov.react_web_service.web.dto;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.*;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Dto для {@link Product}
 */
@Value
@Builder
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private Category category;
    private String type;
    private String subType;
    private String brand;
    private BigDecimal price;
    private Integer size;
    private String namedSize;
    private Gender gender;
    private Age age;
    private String color;
    private Boolean isNew;
    private Boolean isSales;
    private Set<byte[]> images;

    /**
     * Фабричный метод. Возвращает {@link ProductDto} из переданного {@link Product}
     */
    public static ProductDto fromProduct(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .type(product.getType())
                .subType(product.getSubType())
                .brand(product.getBrand())
                .price(product.getPrice())
                .size(product.getSize())
                .namedSize(product.getNamedSize())
                .gender(product.getGender())
                .age(product.getAge())
                .color(product.getColor())
                .isNew(product.getIsNew())
                .isSales(product.getIsSales())
                .images(product.getImages())
                .build();
    }
}
