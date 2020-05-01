package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Category;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;
import com.plekhanov.react_web_service.infrastructure.search_params.ProductSearchParams;
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
 *
 */
@RestController
@RequestMapping("public/api/v1/product")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    /**
     * Возвращает типы Товаров, по выбранным параметрам
     */
    @GetMapping("types")
    public ApiResponse<Set<String>> getTypes(
            @RequestParam("category") Category category,
            @RequestParam(value = "age", required = false) Age age,
            @RequestParam(value = "gender", required = false) Gender gender) {

        Set<String> productTypes = productService.getTypesByParameters(category, age, gender);
        return ApiResponse.ok(productTypes);
    }

    /**
     * Возвращает Товары, по выбранным параметрам
     */
    @GetMapping("search")
    public ApiResponse<Set<ProductDto>> search(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) Category category,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "subType", required = false) String subType,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "priceFrom", required = false) BigDecimal priceFrom,
            @RequestParam(value = "priceTo", required = false) BigDecimal priceTo,
            @RequestParam(value = "sizeFrom", required = false) Integer sizeFrom,
            @RequestParam(value = "sizeTo", required = false) Integer sizeTo,
            @RequestParam(value = "namedSize", required = false) String namedSize,
            @RequestParam(value = "gender", required = false) Gender gender,
            @RequestParam(value = "age", required = false) Age age,
            @RequestParam(value = "color", required = false) String color,
            @RequestParam(value = "isNew", required = false) Boolean isNew,
            @RequestParam(value = "isSales", required = false) Boolean isSales) {

        ProductSearchParams productSearchParams = ProductSearchParams.builder()
                .name(name)
                .category(category)
                .type(type)
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

        Set<Product> products = productService.search(productSearchParams);
        Set<ProductDto> productsDto = products.stream().map(ProductDto::fromProduct).collect(Collectors.toSet());
        return ApiResponse.ok(productsDto);
    }


    /**
     * Добавить товар в корзину
     */
    @PostMapping("add-to-bag")
    public void addToBag() {
        //TODO
    }

    /**
     * Добавить товар в избранное
     */
    @PostMapping("add-to-favorite")
    public void addToFavorite() {
        //TODO
    }

}

