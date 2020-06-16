package com.plekhanov.react_web_service.web.dto;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import lombok.Builder;
import lombok.Value;

/**
 * Dto для {@link ProductType}
 */
@Value
@Builder
public class ProductTypeDto {

    Integer id;
    String name;
    Gender gender;
    Category category;

    /**
     * Фабричный метод. Возвращает {@link ProductTypeDto} из переданного {@link ProductType}
     */
    public static ProductTypeDto fromProductType(final ProductType product) {
        return ProductTypeDto.builder()
                .id(product.getId())
                .name(product.getName())
                .gender(product.getGender())
                .category(product.getCategory())
                .build();
    }
}
