package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.Product.Category;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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
     * Возвращает типы Товара, по выбранным параметрам
     */
    @GetMapping("type-list")
    public ApiResponse<Set<String>> searchProducts(
            @RequestParam("category") Category category,
            @RequestParam("age") Age age,
            @RequestParam("gender") Gender gender) {

        Set<String> productTypesByCategory = productService.getTypesByParameters(category, age, gender);
        return ApiResponse.ok(productTypesByCategory);
    }

}

