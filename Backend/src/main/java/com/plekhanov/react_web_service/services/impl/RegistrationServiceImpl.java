package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.services.RegistrationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public void registration(final String username, final String email, final String password) {
        //TODO
        throw new RuntimeException("not implemented!");
    }

}
