package com.plekhanov.react_web_service.web.dto;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import lombok.Builder;
import lombok.Value;

/**
 * Dto для {@link ProductType}
 */
@Value
@Builder
public class ProductTypeDto {

    private Integer id;
    private String name;
    private Category category;

    /**
     * Фабричный метод. Возвращает {@link ProductTypeDto} из переданного {@link ProductType}
     */
    public static ProductTypeDto fromProduct(ProductType product) {
        return ProductTypeDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .build();
    }
}
