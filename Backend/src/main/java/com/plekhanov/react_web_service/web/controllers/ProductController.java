package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.Product.Category;
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
     * Возвращает типы Товара, выбранной категории
     */
    @GetMapping("type-list")
    public ApiResponse<Set<String>> searchProducts(@RequestParam("category") Category category) {

        Set<String> productTypesByCategory = productService.getTypesByCategory(category);
        return ApiResponse.ok(productTypesByCategory);
    }

}
