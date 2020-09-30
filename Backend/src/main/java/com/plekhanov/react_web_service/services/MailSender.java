package com.plekhanov.react_web_service.services;

public interface MailSender {

    void sendMail(final String email, final String confirmCode);

}
