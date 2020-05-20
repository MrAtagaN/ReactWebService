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

    Integer id;
    String name;
    String description;
    ProductTypeDto type;
    String subType;
    String brand;
    BigDecimal price;
    Integer size;
    String namedSize;
    Gender gender;
    Age age;
    String color;
    Boolean isNew;
    Boolean isSales;
    Set<byte[]> images;

    /**
     * Фабричный метод. Возвращает {@link ProductDto} из переданного {@link Product}
     */
    public static ProductDto fromProduct(final Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .type(ProductTypeDto.fromProductType(product.getType()))
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
