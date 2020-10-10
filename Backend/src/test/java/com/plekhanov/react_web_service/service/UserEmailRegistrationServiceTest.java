package com.plekhanov.react_web_service.service;

import com.plekhanov.react_web_service.config.security.Authority;
import com.plekhanov.react_web_service.dao.UserDao;
import com.plekhanov.react_web_service.dao.UserRegistrationDao;
import com.plekhanov.react_web_service.entities.User;
import com.plekhanov.react_web_service.entities.UserRegistrationRequest;
import com.plekhanov.react_web_service.services.MailSender;
import com.plekhanov.react_web_service.services.impl.UserEmailRegistrationService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class UserEmailRegistrationServiceTest {

    @MockBean
    UserRegistrationDao userRegistrationDao;

    @MockBean
    UserDao userDao;

    @MockBean
    MailSender mailSender;

    @Autowired
    UserEmailRegistrationService userEmailRegistrationService;

    @Test
    public void userRegistrationRequestTest() {

        final String email = "testEmail@rambler.ru";
        final String userName = "Max";
        final String password = "someTestPassword";

        userEmailRegistrationService.userRegistrationRequest(userName, email, password);

        Mockito.verify(userRegistrationDao, Mockito.times(1))
                .save(Mockito.any());
        Mockito.verify(mailSender, Mockito.times(1))
                .sendUserRegistrationConfirmCodeMail(Mockito.anyString(), Mockito.anyString());

    }


    @Test
    public void confirmEmailTest() {

        final String email = "testEmail@rambler.ru";
        final String confirmCode = "5142";
        final String userName = "Max";
        final String userPassword = "abc1";

        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setUsername(userName);
        userRegistrationRequest.setEmail(email);
        userRegistrationRequest.setConfirmCode(confirmCode);
        userRegistrationRequest.setPassword(userPassword);

        Mockito.when(userRegistrationDao.findByEmail(email)).thenReturn(userRegistrationRequest);

        userEmailRegistrationService.confirmEmail(email, confirmCode);

        Mockito.verify(userDao, Mockito.times(1)).save(Mockito.any());
        Mockito.verify(userRegistrationDao, Mockito.times(1)).delete(userRegistrationRequest);

    }
}
