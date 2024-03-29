package com.plekhanov.react_web_service.web.api.dto;

import com.plekhanov.react_web_service.model.entities.Product;
import com.plekhanov.react_web_service.model.entities.ProductType.Gender;
import com.plekhanov.react_web_service.model.entities.ProductType.Category;
import com.plekhanov.react_web_service.model.entities.ProductType.Age;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Dto для {@link Product}
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {//TODO выкинуть ненужные аннотации

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

}
