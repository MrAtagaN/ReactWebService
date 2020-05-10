package com.plekhanov.react_web_service.web.controllers.admin;


import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.services.ProductTypeService;
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
@RequestMapping("admin/api/v1/product-type")
@RequiredArgsConstructor
@Validated
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductTypeAdminController {

    private final ProductTypeService productTypeService;

    /**
     * Добавить или изменить {@link ProductType}
     */
    @PostMapping("save-or-update-product-type")
    public ApiResponse<String> saveOrUpdateProductType(
            @RequestBody @NotNull final ProductType productType) {

        productTypeService.saveOrUpdate(productType);
        return ApiResponse.ok("productType saved or updated");
    }

    /**
     * Удалить тип {@link ProductType}
     */
    @PostMapping("delete-productType")
    public ApiResponse<String> deleteProductType(
            @RequestParam("productId") @NotNull final Integer productTypeId) {

        productTypeService.delete(productTypeId);
        return ApiResponse.ok("productType deleted");
    }
}
