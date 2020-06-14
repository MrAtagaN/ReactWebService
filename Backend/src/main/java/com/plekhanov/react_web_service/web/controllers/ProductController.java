package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.web.ApiResponse;
import com.plekhanov.react_web_service.web.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import static com.plekhanov.react_web_service.web.ApiResponse.ResponseCode.VALIDATION_ERROR;

/**
 * Эндпойты для действий с {@link Product}
 */
@RestController
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    private static final String PUBLIC = "public/";
    private static final String ADMIN = "admin/";
    private static final String API_VERSION = "api/v1/product/";


    /**
     * Возвращает {@link Product}, по выбранным параметрам
     */
    @GetMapping(PUBLIC + API_VERSION + "search")
    public ApiResponse search(
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
            @RequestParam(value = "isSales", required = false) final Boolean isSales,
            @RequestParam(value = "page", required = false, defaultValue = "0") final Integer page,
            @RequestParam(value = "itemsInPage", required = false, defaultValue = "9") final Integer itemsInPage) {

        if (itemsInPage != null && itemsInPage > 100) {
            return ApiResponse.error(VALIDATION_ERROR, "parameter itemsInPage is very big");
        }

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
                .page(page)
                .itemsInPage(itemsInPage)
                .build();

        final Set<Product> products = productService.search(productSearchParams);
        final Set<ProductDto> productsDto = products.stream()
                .map(ProductDto::fromProduct)
                .collect(Collectors.toSet());
        return ApiResponse.ok(productsDto);
    }


    /**
     * Добавить или изменить {@link Product}
     */
    @PostMapping(ADMIN + API_VERSION + "save-or-update")
    public ApiResponse<String> saveOrUpdateProduct(@RequestBody @NotNull final Product product) {
        productService.saveOrUpdate(product);
        return ApiResponse.ok("product saved or updated");
    }


    /**
     * Удалить {@link Product}
     */
    @PostMapping(ADMIN + API_VERSION + "delete")
    public ApiResponse<String> deleteProduct(@RequestParam("productId") @NotNull final Integer productId) {
        productService.delete(productId);
        return ApiResponse.ok("product deleted");
    }


}

