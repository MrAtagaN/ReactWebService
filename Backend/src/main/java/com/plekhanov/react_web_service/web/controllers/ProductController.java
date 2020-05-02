package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import com.plekhanov.react_web_service.web.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Открытые эндпойты для получения {@link Product}
 */
@RestController
@RequestMapping("public/api/v1/product")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;


    /**
     * Возвращает Товары, по выбранным параметрам
     */
    @GetMapping("search")
    public ApiResponse<Set<ProductDto>> search(
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "type", required = false) final Integer type,
            @RequestParam(value = "subType", required = false) final String subType,
            @RequestParam(value = "brand", required = false) final String brand,
            @RequestParam(value = "priceFrom", required = false) final BigDecimal priceFrom,
            @RequestParam(value = "priceTo", required = false) final BigDecimal priceTo,
            @RequestParam(value = "sizeFrom", required = false) final Integer sizeFrom,
            @RequestParam(value = "sizeTo", required = false) final Integer sizeTo,
            @RequestParam(value = "namedSize", required = false) final String namedSize,
            @RequestParam(value = "gender", required = false) final Gender gender,
            @RequestParam(value = "age", required = false) final Age age,
            @RequestParam(value = "color", required = false) final String color,
            @RequestParam(value = "isNew", required = false) final Boolean isNew,
            @RequestParam(value = "isSales", required = false) final Boolean isSales) {

        final ProductSearchParams productSearchParams = ProductSearchParams.builder()
                .name(name)
                .typeId(type)
                .subType(subType)
                .brand(brand)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .sizeFrom(sizeFrom)
                .sizeTo(sizeTo)
                .namedSize(namedSize)
                .gender(gender)
                .age(age)
                .color(color)
                .isNew(isNew)
                .isSales(isSales)
                .build();

        final Set<Product> products = productService.search(productSearchParams);
        final Set<ProductDto> productsDto = products.stream()
                .map(ProductDto::fromProduct)
                .collect(Collectors.toSet());
        return ApiResponse.ok(productsDto);
    }


}

