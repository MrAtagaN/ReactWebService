package com.plekhanov.react_web_service.web.api.dto;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Age;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Dto для {@link Product}
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
