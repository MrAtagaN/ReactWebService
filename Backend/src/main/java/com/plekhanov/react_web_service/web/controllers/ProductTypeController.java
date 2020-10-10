package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Age;
import com.plekhanov.react_web_service.services.ProductTypeService;
import com.plekhanov.react_web_service.web.api.ApiResponse;
import com.plekhanov.react_web_service.web.api.dto.ProductTypeDto;
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
     * Возвращает {@link ProductType}, по выбранным параметрам
     */
    @GetMapping(PUBLIC + API_VERSION + "search")
    public ApiResponse<Set<ProductTypeDto>> getTypes(
            @RequestParam(value = "type", required = false) final String type,
            @RequestParam(value = "gender", required = false) final Gender gender,
            @RequestParam(value = "age", required = false) final Age age,
            @RequestParam(value = "category", required = false) final Category category) {

        final Set<ProductType> productTypes = productTypeService.findByParameters(type, gender, age, category);
        final Set<ProductTypeDto> productTypeDtos = productTypes.stream()
                .map(ProductTypeDto::fromProductType)
                .collect(Collectors.toSet());
        return ApiResponse.ok(productTypeDtos);
    }


    /**
     * Добавить или изменить {@link ProductType}
     */
    @PostMapping(ADMIN + API_VERSION + "save-or-update")
    public ApiResponse<String> saveOrUpdateProductType(@RequestBody @NotNull final ProductType productType) {
        productTypeService.saveOrUpdate(productType);
        return ApiResponse.ok("productType saved or updated");
    }


    /**
     * Удалить {@link ProductType}
     */
    @PostMapping(ADMIN + API_VERSION + "delete")
    public ApiResponse<String> deleteProductType(@RequestParam("productId") @NotNull final Integer productTypeId) {
        productTypeService.deleteById(productTypeId);
        return ApiResponse.ok("productType deleted");
    }


}
