package com.plekhanov.react_web_service.web.api.dto;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Age;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
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
    String brand;
    BigDecimal price;
    Set<Integer> size;
    Set<String> namedSize;
    Integer productTypeId;
    Gender gender;
    String type;
    Category category;
    Age age;
    String color;
    Boolean isNew;
    Boolean isSales;
    List<byte[]> images;
    Integer mainImageNumber;


    /**
     * Фабричный метод. Возвращает {@link ProductDto} из переданного {@link Product}
     */
    public static ProductDto fromProduct(final Product product) {
        if (product == null) {
            return null;
        }
        ProductType productType = product.getType();

        Gender gender = null;
        String type = null;
        Category category = null;
        Age age = null;
        Integer productTypeId = null;
        if (productType != null) {
            gender = productType.getGender();
            type = productType.getType();
            category = productType.getCategory();
            age =  productType.getAge();
            productTypeId = productType.getId();
        }

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .brand(product.getBrand())
                .price(product.getPrice())
                .size(product.getSize())
                .namedSize(product.getNamedSize())
                .gender(gender)
                .type(type)
                .category(category)
                .age(age)
                .productTypeId(productTypeId)
                .color(product.getColor())
                .isNew(product.getIsNew())
                .isSales(product.getIsSales())
                .images(product.getImages())
                .mainImageNumber(product.getMainImageNumber())
                .build();
    }
}
