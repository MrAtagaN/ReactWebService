package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.ProductType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.List;

/**
 * Dao для {@link Product}
 */
@Validated
public interface ProductDao extends JpaRepository<Product, Integer> {

    @Query("SELECT distinct p FROM Product p inner join p.size s WHERE " +
            "(:name is null or p.name like concat('%', :name,'%')) and " +
            "(:typeId is null or p.type = :typeId) and " +
            "(:brand is null or p.brand = :brand) and " +
            "(:priceFrom is null or p.price >= :priceFrom) and " +
            "(:priceTo is null or p.price <= :priceTo) and " +
            "(:sizeFrom is null or  s >= :sizeFrom) and " +
            "(:sizeTo is null or s <= :sizeTo) and " +
            "(:namedSize is null or :namedSize in elements(p.namedSize)) and " +
            "(:gender is null or p.type.gender = :gender) and " +
            "(:typee is null or p.type.type = :typee) and " +
            "(:age is null or p.type.age = :age) and " +
            "(:color is null or p.color = :color) and " +
            "(:isNew is null or p.isNew = :isNew) and " +
            "(:isSales is null or p.isSales = :isSales)")
    List<Product> findByParameters(@Param("name") String name,
                                   @Param("typeId") Integer typeId,
                                   @Param("brand") String brand,
                                   @Param("priceFrom") BigDecimal priceFrom,
                                   @Param("priceTo") BigDecimal priceTo,
                                   @Param("sizeFrom") Integer sizeFrom,
                                   @Param("sizeTo") Integer sizeTo,
                                   @Param("namedSize") String namedSize,
                                   @Param("gender") ProductType.Gender gender,
                                   @Param("typee") String type,
                                   @Param("age") ProductType.Age age,
                                   @Param("color") String color,
                                   @Param("isNew") Boolean isNew,
                                   @Param("isSales") Boolean isSales,
                                   Pageable pageRequest);

}
