package com.plekhanov.react_web_service.services;

import com.plekhanov.react_web_service.model.entities.ProductType;
import com.plekhanov.react_web_service.model.entities.ProductType.*;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Сервис для {@link ProductType}
 */
@Validated
public interface ProductTypeService {

    ProductType saveOrUpdate(@NotNull ProductType productType);

    void deleteById(int id);

    Set<ProductType> findByParameters(@Nullable String type,
                                      @Nullable Gender gender,
                                      @Nullable Age age,
                                      @Nullable Category category);

}
