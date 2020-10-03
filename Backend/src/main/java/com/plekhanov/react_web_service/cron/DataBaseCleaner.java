package com.plekhanov.react_web_service.cron;

/**
 * Очистка базы по расписанию
 */
public interface DataBaseCleaner {


    /**
     *  Очищаем базу от неподтверждённых запросов на регистрацию новых пользователей
     */
    void cleanUserRegistrationRequest();
}
