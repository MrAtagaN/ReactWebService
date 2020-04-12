package com.plekhanov.react_web_service.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Integer id;
    private String username;
    private String password;

}
