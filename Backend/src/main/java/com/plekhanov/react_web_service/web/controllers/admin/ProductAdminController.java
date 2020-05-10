package com.plekhanov.react_web_service.web.controllers.admin;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.web.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Доступ пользователей с ролью ADMIN к {@link Product}
 */
@RestController
@RequestMapping("admin/api/v1/product")
@RequiredArgsConstructor
@Validated
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductAdminController {

    private final ProductService productService;


    /**
     * Добавить или изменить {@link Product}
     */
    @PostMapping("save-or-update-product")
    public ApiResponse<String> saveOrUpdateProduct(
            @RequestBody @NotNull final Product product) {

        productService.saveOrUpdate(product);
        return ApiResponse.ok("product saved or updated");
    }


    /**
     * Удалить {@link Product}
     */
    @PostMapping("delete-product")
    public ApiResponse<String> deleteProduct(
            @RequestParam("productId") @NotNull final Integer productId) {

        productService.delete(productId);
        return ApiResponse.ok("product deleted");
    }


}
