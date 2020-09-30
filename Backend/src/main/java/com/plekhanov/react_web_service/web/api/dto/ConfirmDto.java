package com.plekhanov.react_web_service.web.api.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ConfirmDto {

    String email;
    String confirmCode;

}
