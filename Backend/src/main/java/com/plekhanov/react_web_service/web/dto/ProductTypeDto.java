package com.plekhanov.react_web_service.web.dto;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Age;
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
    Age age;
    Category category;


    /**
     * Фабричный метод. Возвращает {@link ProductTypeDto} из переданного {@link ProductType}
     */
    public static ProductTypeDto fromProductType(final ProductType productType) {
        if (productType == null) {
            return null;
        }
        return ProductTypeDto.builder()
                .id(productType.getId())
                .name(productType.getName())
                .gender(productType.getGender())
                .age(productType.getAge())
                .category(productType.getCategory())
                .build();
    }
}
