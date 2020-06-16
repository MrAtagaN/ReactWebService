package com.plekhanov.react_web_service.entities.search_params;


import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.*;
import lombok.Builder;
import lombok.Value;

/**
 * Параметры поиска объектов {@link ProductType}
 */
@Value
@Builder
public class ProductTypeSearchParams {

    String name;
    Gender gender;
    Age age;
    Category category;

}
