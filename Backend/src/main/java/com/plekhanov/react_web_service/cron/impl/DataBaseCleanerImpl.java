package com.plekhanov.react_web_service.cron.impl;

import com.plekhanov.react_web_service.cron.DataBaseCleaner;
import com.plekhanov.react_web_service.dao.UserRegistrationDao;
import com.plekhanov.react_web_service.entities.UserRegistrationRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DataBaseCleanerImpl implements DataBaseCleaner {

   UserRegistrationDao userRegistrationDao;


    /**
     *  Очищаем базу от неподтверждённых запросов на регистрация новых пользователей
     */
    @Scheduled(cron="30 * * * * *", zone="Europe/Istanbul")
    @Async
    public void cleanUserRegistrationRequest() {
        List<UserRegistrationRequest> userRegistrationRequests = userRegistrationDao.findAll();

        userRegistrationRequests.stream().filter(request -> request.getCreationTime().isBefore(LocalDateTime.now()
                .minusMinutes(5))).forEach(userRegistrationDao::delete);
    }
}
