package com.plekhanov.react_web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Запуск приложения
 * Приложение доступно на http://localhost:443/
 */
@SpringBootApplication
@EnableScheduling
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    /**
//     * Aspect for profiling method execution time
//     */
//    @Aspect
//    @Component
//    @ConditionalOnProperty(name = "application.profiling.enabled", havingValue = "true")
//    @Slf4j
//    public class ProfilingAspect {
//        @Around("@annotation(ru.sbrf.callcenter.stat.aspect.Profiling)")
//        public Object profiling(ProceedingJoinPoint pjp) throws Throwable {
//            long start = System.currentTimeMillis();
//            final String methodName = pjp.getStaticPart().toShortString();
//            final Object proceed = pjp.proceed();
//            log.info("[Profiling] Completed {} method in {} ms", methodName, System.currentTimeMillis() - start);
//            return proceed;
//        }
//    }



    //текущее: На фронте отображать товар
    //юнит тесты

    //TODO:
    // Функциональные:
    // На фронте Выводить данные постранично
    // Обработать ошибку, если нет эндпойнта
    // ================
    // Не функциональные:
    // Добавить кэш для запросов
    // сделать csrf
    // Тест dao
    // Тесты controllers
    // Swagger
    // Валидация Entity
    // Зарефакторить POM
    // Ограничение длины полей на уровне базы
    // Логгирование в коде
    // Добавить в базу больше товара
    // Заполнение данных в базе вынести в скрипты или сделать модуль common
    // Добавить актуатор
    // Убрать @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)


    /**
     * Требования к Pull Request:
     *
     * валидировать параметры NotNull, Size, NotBlank, NotEmpty
     * Чистые функции
     * модификаторы final у параметров методов
     * Immutable классы
     * Внедрение зависимостей через конструкотор
     * Java doc. Что делает, для чего нужно
     * Понятные названия методов и переменных
     * Переменные вынесены в property
     * Индексы на внешние ключи
     * Логирование
     * Тесты
     * Применение паттернов
     */

}
