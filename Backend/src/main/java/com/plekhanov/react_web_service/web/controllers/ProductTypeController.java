package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.services.ProductTypeService;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import com.plekhanov.react_web_service.web.dto.ProductTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Эндпойты для действий с {@link ProductType}
 */
@RestController
@RequiredArgsConstructor
@Validated
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    private static final String PUBLIC = "public/";
    private static final String ADMIN = "admin/";
    private static final String API_VERSION = "api/v1/product-type/";


    /**
     * Возвращает Типы Товаров в категории
     */
    @GetMapping(PUBLIC + API_VERSION + "search")
    public ApiResponse<Set<ProductTypeDto>> getTypes(
            @RequestParam(value = "category") final Category category) {
        final Set<ProductType> productTypes = productTypeService.findByCategory(category);
        final Set<ProductTypeDto> productTypeDtos = productTypes.stream()
                .map(ProductTypeDto::fromProductType)
                .collect(Collectors.toSet());
        return ApiResponse.ok(productTypeDtos);
    }


    /**
     * Добавить или изменить {@link ProductType}
     */
    @PostMapping(ADMIN + API_VERSION + "save-or-update")
    public ApiResponse<String> saveOrUpdateProductType(
            @RequestBody @NotNull final ProductType productType) {

        productTypeService.saveOrUpdate(productType);
        return ApiResponse.ok("productType saved or updated");
    }


    /**
     * Удалить тип {@link ProductType}
     */
    @PostMapping(ADMIN + API_VERSION + "delete")
    public ApiResponse<String> deleteProductType(
            @RequestParam("productId") @NotNull final Integer productTypeId) {

        productTypeService.delete(productTypeId);
        return ApiResponse.ok("productType deleted");
    }


}
