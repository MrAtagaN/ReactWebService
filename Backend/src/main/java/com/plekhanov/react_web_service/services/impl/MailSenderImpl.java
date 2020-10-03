package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.services.MailSender;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MailSenderImpl implements MailSender {

    JavaMailSenderImpl mailSender;


    @Override
    public void sendUserRegistrationConfirmCodeMail(final String email, final String confirmCode) {
        final SimpleMailMessage message = new SimpleMailMessage(); //TODO формировать письмо из шаблона
        message.setTo(email);
        message.setFrom("JavaProjectMail@rambler.ru");//TODO вынести в параметры
        message.setSubject("Confirm code");
        message.setText(confirmCode);

        mailSender.send(message);
    }
}
