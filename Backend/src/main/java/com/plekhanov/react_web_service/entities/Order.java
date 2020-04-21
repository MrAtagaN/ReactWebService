package com.plekhanov.react_web_service.entities;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Заказ
 */
public class Order {

    private Long id;

    private Integer userId;
    private List<Product> products;
    private LocalDateTime createdAt;
    private Address address;
    private Status status;


    public enum Status {

    }

}
