package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.services.ProductTypeService;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import com.plekhanov.react_web_service.web.dto.ProductTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Открытые эндпойты для получения {@link ProductType}
 */
@RestController
@RequestMapping("public/api/v1/product-type")
@RequiredArgsConstructor
@Validated
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    /**
     * Возвращает типы Товаров
     */
    @GetMapping("all")
    public ApiResponse<Set<ProductTypeDto>> getTypes() {
        Set<ProductType> all = productTypeService.getAll();
        Set<ProductTypeDto> productTypeDtos = all.stream().map(ProductTypeDto::fromProductType).collect(Collectors.toSet());

        return ApiResponse.ok(productTypeDtos);
    }


}
