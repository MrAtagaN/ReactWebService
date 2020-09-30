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
    public void sendMail(final String email, final String confirmCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom("JavaProjectMail@rambler.ru");
        message.setSubject("Confirm code");
        message.setText(confirmCode);

        mailSender.send(message);

    }
}
