package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.services.RegistrationService;
import com.plekhanov.react_web_service.entities.UserRegistrationRequest;
import com.plekhanov.react_web_service.entities.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

/**
 * Создание нового пользователя через email
 */
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailRegistrationService implements RegistrationService {

    /**
     * Создает в базе запись {@link UserRegistrationRequest}, посылает на почту ссылку для подтверждения email
     */
    @Override
    public void registrationRequest(final String username, final String email, final String password) {
        //TODO послать на почту ссылку для подтверждения, создать в  таблице user_registration_request запись

        throw new RuntimeException("not implemented!");
    }


    /**
     * При успешном подтверждении, создает нового {@link User}
     */
    @Override
    public void confirmEmail(final String email, final String confirmCode) {
        throw new RuntimeException("not implemented!");
    }

}
