package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.ProductType;
import com.plekhanov.react_web_service.entities.ProductType.Category;
import com.plekhanov.react_web_service.entities.ProductType.Gender;
import com.plekhanov.react_web_service.entities.ProductType.Age;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

/**
 * Dao для {@link ProductType}
 */
@Validated
public interface ProductTypeDao extends JpaRepository<ProductType, Integer> {

    @Query("SELECT p FROM ProductType p WHERE " +
            "(:type is null or p.type = :type) and " +
            "(:gender is null or p.gender = :gender) and " +
            "(:age is null or p.age = :age) and " +
            "(:category is null or p.category = :category)")
    Set<ProductType> findByParameters(@Param("type") String type,
                                      @Param("gender") Gender gender,
                                      @Param("age") Age age,
                                      @Param("category") Category category);

}
