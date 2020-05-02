package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;
import com.plekhanov.react_web_service.entities.search_params.ProductSearchParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ProductDaoImpl implements ProductDao {

    private final SessionFactory sessionFactory;


    @Override
    public Product findById(final int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Product.class, id);
        }
    }

    @Override
    public Product saveOrUpdate(final Product product) {
        Product savedProduct = null;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            savedProduct = (Product) session.merge(product);
            transaction.commit();
        } catch (Exception e) {
            log.error("Error while save Product", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return savedProduct;
    }


    @Override
    public Set<Product> search(ProductSearchParams productSearchParams) {
        try (Session session = sessionFactory.openSession()) {
            Map<String, Object> params = new HashMap<>();
            StringBuilder stringQuery = new StringBuilder("FROM Product p WHERE 1=1");

            String name = productSearchParams.getName();
            if (name != null) {
                stringQuery.append(" and p.name = :name");
                params.put("name", name);
            }
            Integer typeId = productSearchParams.getTypeId();
            if (typeId != null) {
                stringQuery.append(" and p.type.id = :typeId");
                params.put("typeId", typeId);
            }
            String subType = productSearchParams.getSubType();
            if (subType != null) {
                stringQuery.append(" and p.subType = :subType");
                params.put("subType", subType);
            }
            String brand = productSearchParams.getBrand();
            if (brand != null) {
                stringQuery.append(" and p.brand = :brand");
                params.put("brand", brand);
            }
            BigDecimal priceFrom = productSearchParams.getPriceFrom();
            if (priceFrom != null) {
                stringQuery.append(" and p.price >= :priceFrom");
                params.put("priceFrom", priceFrom);
            }
            BigDecimal priceTo = productSearchParams.getPriceTo();
            if (priceTo != null) {
                stringQuery.append(" and p.price <= :priceTo");
                params.put("priceTo", priceTo);
            }
            Integer sizeFrom = productSearchParams.getSizeFrom();
            if (sizeFrom != null) {
                stringQuery.append(" and p.size >= :sizeFrom");
                params.put("sizeFrom", sizeFrom);
            }
            Integer sizeTo = productSearchParams.getSizeTo();
            if (sizeTo != null) {
                stringQuery.append(" and p.size <= :sizeTo");
                params.put("sizeTo", sizeTo);
            }
            String namedSize = productSearchParams.getNamedSize();
            if (namedSize != null) {
                stringQuery.append(" and p.namedSize = :namedSize");
                params.put("namedSize", namedSize);
            }
            Gender gender = productSearchParams.getGender();
            if (gender != null) {
                stringQuery.append(" and p.gender = :gender");
                params.put("gender", gender);
            }
            Age age = productSearchParams.getAge();
            if (age != null) {
                stringQuery.append(" and p.age = :age");
                params.put("age", age);
            }
            String color = productSearchParams.getColor();
            if (color != null) {
                stringQuery.append(" and p.color = :color");
                params.put("color", color);
            }
            Boolean isNew = productSearchParams.getIsNew();
            if (isNew != null) {
                stringQuery.append(" and p.isNew = :isNew");
                params.put("isNew", isNew);
            }
            Boolean isSales = productSearchParams.getIsSales();
            if (isSales != null) {
                stringQuery.append(" and p.isSales = :isSales");
                params.put("isSales", isSales);
            }

            final Query<Product> query = session.createQuery(stringQuery.toString(), Product.class);
            query.setProperties(params);
            return new HashSet<>(query.list()) ;
        }
    }
}
