package com.plekhanov.react_web_service.services;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;


@Validated
public interface MailSender {

    /**
     * Послать письмо с проверочным кодом для регистрации нового пользователя
     */
    void sendUserRegistrationConfirmCodeMail(@NotNull String email, @NotNull String confirmCode);

}
