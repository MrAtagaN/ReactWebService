package com.plekhanov.react_web_service.dao.impl;

import com.plekhanov.react_web_service.dao.ProductDao;
import com.plekhanov.react_web_service.entities.Product;
import com.plekhanov.react_web_service.entities.Product.Age;
import com.plekhanov.react_web_service.entities.Product.Gender;
import com.plekhanov.react_web_service.entities.search_params.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductDaoImpl implements ProductDao {

    SessionFactory sessionFactory;


    @Override
    public Product findById(final int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Product.class, id);
        } catch (Exception e) {
            log.error("Error while find Product, id: {}, {}", id, e.getMessage());
            throw e;
        }
    }


    @Override
    public void delete(final int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            final Product product = session.load(Product.class, id);
            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            log.error("Error while delete Product, id: {}, {}", id, e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }


    @Override
    public Product saveOrUpdate(final Product product) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            final Product savedProduct = (Product) session.merge(product);
            transaction.commit();
            return savedProduct;
        } catch (Exception e) {
            log.error("Error while save Product, {}", e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }


    @Override
    public Set<Product> search(final ProductSearchParams productSearchParams) {
        try (Session session = sessionFactory.openSession()) {
            final Map<String, Object> params = new HashMap<>();
            final StringBuilder stringQuery = new StringBuilder("FROM Product p WHERE 1=1");

            final String name = productSearchParams.getName();
            if (name != null) {
                stringQuery.append(" and p.name = :name");
                params.put("name", name);
            }
            final Integer typeId = productSearchParams.getTypeId();
            if (typeId != null) {
                stringQuery.append(" and p.type.id = :typeId");
                params.put("typeId", typeId);
            }
            final String subType = productSearchParams.getSubType();
            if (subType != null) {
                stringQuery.append(" and p.subType = :subType");
                params.put("subType", subType);
            }
            final String brand = productSearchParams.getBrand();
            if (brand != null) {
                stringQuery.append(" and p.brand = :brand");
                params.put("brand", brand);
            }
            final BigDecimal priceFrom = productSearchParams.getPriceFrom();
            if (priceFrom != null) {
                stringQuery.append(" and p.price >= :priceFrom");
                params.put("priceFrom", priceFrom);
            }
            final BigDecimal priceTo = productSearchParams.getPriceTo();
            if (priceTo != null) {
                stringQuery.append(" and p.price <= :priceTo");
                params.put("priceTo", priceTo);
            }
            final Integer sizeFrom = productSearchParams.getSizeFrom();
            if (sizeFrom != null) {
                stringQuery.append(" and minelement(p.size) >= :sizeFrom");
                params.put("sizeFrom", sizeFrom);
            }
            final Integer sizeTo = productSearchParams.getSizeTo();
            if (sizeTo != null) {
                stringQuery.append(" and maxelement(p.size) <= :sizeTo");
                params.put("sizeTo", sizeTo);
            }
            final String namedSize = productSearchParams.getNamedSize();
            if (namedSize != null) {
                stringQuery.append(" and :namedSize in elements(p.namedSize)");
                params.put("namedSize", namedSize);
            }
            final Gender gender = productSearchParams.getGender();
            if (gender != null) {
                stringQuery.append(" and p.gender = :gender");
                params.put("gender", gender);
            }
            final Age age = productSearchParams.getAge();
            if (age != null) {
                stringQuery.append(" and p.age = :age");
                params.put("age", age);
            }
            final String color = productSearchParams.getColor();
            if (color != null) {
                stringQuery.append(" and p.color = :color");
                params.put("color", color);
            }
            final Boolean isNew = productSearchParams.getIsNew();
            if (isNew != null) {
                stringQuery.append(" and p.isNew = :isNew");
                params.put("isNew", isNew);
            }
            final Boolean isSales = productSearchParams.getIsSales();
            if (isSales != null) {
                stringQuery.append(" and p.isSales = :isSales");
                params.put("isSales", isSales);
            }

            final Query<Product> query = session.createQuery(stringQuery.toString(), Product.class);
            query.setProperties(params);

            final Integer page = productSearchParams.getPage();
            final Integer itemsInPage = productSearchParams.getItemsInPage();
            if (page != null && itemsInPage != null) {
                query.setFirstResult(page * itemsInPage);
                query.setMaxResults(itemsInPage);
            }

            return new HashSet<>(query.list());
        } catch (Exception e) {
            log.error("Error while search Product: {}", e.getMessage());
            throw e;
        }
    }

    public int count() {
        return 0;//TODO
    }
}
