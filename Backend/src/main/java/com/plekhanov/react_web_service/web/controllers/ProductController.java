package com.plekhanov.react_web_service.web.controllers;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType.Age;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import com.plekhanov.react_web_service.services.ProductService;
import com.plekhanov.react_web_service.web.api.ApiResponse;
import com.plekhanov.react_web_service.web.api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.plekhanov.react_web_service.web.api.ApiResponse.ResponseCode.VALIDATION_ERROR;

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
    private static final String DEFAULT_VALUE_ITEMS_IN_PAGE = "9";


    /**
     * Возвращает {@link Product}, по выбранным параметрам
     */
    @GetMapping(PUBLIC + API_VERSION + "search")
    public ApiResponse<?> search(
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "typeId", required = false) final Integer typeId,
            @RequestParam(value = "brand", required = false) final String brand,
            @RequestParam(value = "priceFrom", required = false) final BigDecimal priceFrom,
            @RequestParam(value = "priceTo", required = false) final BigDecimal priceTo,
            @RequestParam(value = "sizeFrom", required = false) final Integer sizeFrom,
            @RequestParam(value = "sizeTo", required = false) final Integer sizeTo,
            @RequestParam(value = "namedSize", required = false) final String namedSize,
            @RequestParam(value = "gender", required = false) final Gender gender,
            @RequestParam(value = "type", required = false) final String type,
            @RequestParam(value = "age", required = false) final Age age,
            @RequestParam(value = "color", required = false) final String color,
            @RequestParam(value = "isNew", required = false) final Boolean isNew,
            @RequestParam(value = "isSales", required = false) final Boolean isSales,
            @RequestParam(value = "page", required = false, defaultValue = "0") final Integer page,
            @RequestParam(value = "itemsInPage", required = false, defaultValue = DEFAULT_VALUE_ITEMS_IN_PAGE) final Integer itemsInPage) {

        if (itemsInPage != null && itemsInPage > 100) {
            return ApiResponse.error(VALIDATION_ERROR, "value of parameter 'itemsInPage' is very big");
        }

        final ProductSearchParams productSearchParams = ProductSearchParams.builder()
                .name(name)
                .typeId(typeId)
                .brand(brand)
                .priceFrom(priceFrom)
                .priceTo(priceTo)
                .sizeFrom(sizeFrom)
                .sizeTo(sizeTo)
                .namedSize(namedSize)
                .gender(gender)
                .type(type)
                .age(age)
                .color(color)
                .isNew(isNew)
                .isSales(isSales)
                .page(page)
                .itemsInPage(itemsInPage)
                .build();

        final List<Product> products = productService.search(productSearchParams);
        final Set<ProductDto> productsDto = products.stream()
                .map(ProductDto::fromProduct).sorted(Comparator.comparing(ProductDto::getName))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return ApiResponse.ok(productsDto);
    }

    /**
     * Добавить или изменить {@link Product}
     */
    @PostMapping(ADMIN + API_VERSION + "save-or-update")
    public ApiResponse<String> saveOrUpdateProduct(@RequestBody @NotNull final ProductDto productDto) {

        //productService.saveOrUpdate(product);
        return ApiResponse.ok("product saved or updated");
    }


    /**
     * Удалить {@link Product}
     */
    @GetMapping(ADMIN + API_VERSION + "delete")
    public ApiResponse<String> deleteProduct(@RequestParam("productId") @NotNull final Integer productId) {
        productService.deleteById(productId);
        return ApiResponse.ok("product deleted");
    }


}

