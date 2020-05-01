package com.plekhanov.react_web_service.infrastructure.search_params;

import com.plekhanov.react_web_service.entities.Product.*;
import com.plekhanov.react_web_service.entities.Product;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

/**
 * Параметры поиска объектов {@link Product}
 */
@Value
@Builder
public class ProductSearchParams {

    String name;
    //Category category;
    Integer typeId;
    String subType;
    String brand;
    BigDecimal priceFrom;
    BigDecimal priceTo;
    Integer sizeFrom;
    Integer sizeTo;
    String namedSize;
    Gender gender;
    Age age;
    String color;
    Boolean isNew;
    Boolean isSales;
}
