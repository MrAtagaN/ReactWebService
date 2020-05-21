package com.plekhanov.react_web_service.entities;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Заказ //TODO
 */
public class Order {

    Long id;

    Integer userId;
    List<Product> products;
    LocalDateTime createdAt;
    Address address;
    Status status;


    public enum Status {

    }

}
