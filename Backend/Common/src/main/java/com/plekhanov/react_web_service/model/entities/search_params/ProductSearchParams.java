package com.plekhanov.react_web_service.model.entities.search_params;

import com.plekhanov.react_web_service.model.entities.Product;
import com.plekhanov.react_web_service.model.entities.ProductType.Gender;
import com.plekhanov.react_web_service.model.entities.ProductType.Age;
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
    Integer typeId;
    String brand;
    BigDecimal priceFrom;
    BigDecimal priceTo;
    Integer sizeFrom;
    Integer sizeTo;
    String namedSize;
    Gender gender;
    String type;
    Age age;
    String color;
    Boolean isNew;
    Boolean isSales;
    Integer page; // номер интервала
    Integer itemsInPage; //количество объектов в интервале
}
