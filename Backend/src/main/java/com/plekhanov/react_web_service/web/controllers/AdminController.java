package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.services.ProductTypeService;
import com.plekhanov.react_web_service.utils.SecurityUtils;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Доступ пользователей с ролью ADMIN
 */
@RestController
@RequestMapping("api/v1/admin")
@RequiredArgsConstructor
@Validated
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final ProductService productService;
    private final ProductTypeService productTypeService;

    /**
     * Добавить или изменить товар
     */
    @PostMapping("save-or-update-product")
    public ApiResponse<String> saveOrUpdateProduct(
            @RequestBody @NotNull final Product product) {

        productService.saveOrUpdate(product);
        return ApiResponse.ok("product saved or updated");
    }

    /**
     * Удалить товар
     */
    @PostMapping("delete-product")
    public ApiResponse<String> deleteProduct(
            @RequestParam("productId") @NotNull final Integer productId) {

        productService.delete(productId);
        return ApiResponse.ok("product deleted");
    }

    /**
     * Добавить или изменить тип товара
     */
    @PostMapping("save-or-update-product-type")
    public ApiResponse<String> saveOrUpdateProductType(
            @RequestBody @NotNull final ProductType productType) {

        productTypeService.saveOrUpdate(productType);
        return ApiResponse.ok("productType saved or updated");
    }

    /**
     * Удалить тип товара
     */
    @PostMapping("delete-product")
    public ApiResponse<String> deleteProductType(
            @RequestParam("productId") @NotNull final Integer productTypeId) {

        productTypeService.delete(productTypeId);
        return ApiResponse.ok("productType deleted");
    }
}
