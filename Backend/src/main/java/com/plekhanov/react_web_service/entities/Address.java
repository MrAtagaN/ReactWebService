package com.plekhanov.react_web_service.entities;

import lombok.Data;

import javax.annotation.Nullable;
import javax.validation.constraints.Size;

/**
 * Адрес //TODO
 */
@Data
public class Address {

    private Long id;

    @Nullable
    @Size(max = 100)
    private String index;

    @Nullable
    @Size(max = 100)
    private String country;

    @Nullable
    @Size(max = 100)
    private String region;

    @Nullable
    @Size(max = 100)
    private String city;

    @Nullable
    @Size(max = 100)
    private String street;
    @Nullable
    @Size(max = 20)
    private String house;
    @Nullable
    @Size(max = 20)
    private String block;
    @Nullable
    @Size(max = 20)
    private String flat;

}
