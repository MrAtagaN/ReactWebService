# ReactWebService

## Описание

Демонстрационное приложение.

Неавторизованный пользователь может:
- просматривать товары по категориям и типам
- фильтровать товары
- искать товары по ключевым словам
- регистрироваться

Авторизованный пользователь может:
- добавлять товар в закладки
- добавлять товар в корзину
- создавать заказ
- редактировать профиль

Администратор может:
- добавлять, удалять, изменять товар
- добавлять, удалять типы товаров

Используемые технологии:
##### Backend:
- SpringBoot
- SpringSecurity
- Hibernate
- Flyway
- SQLite
- Swagger

##### Frontend:
- React
- Redux


## Установка необходимых программ для сборки

- maven
- java 1.8
- npm (установка: https://nodejs.org/en/download/)


## Сборка

1. В директории Frontend выполнить команду: 'npm install' (Выполняется один раз)
2. В корневой директории проекта (ReactWebService) выполнить комманду: 'mvn clean install'

Результатом сборки будет ReactWebService.jar в корневой директории


## Запуск

1. Выполнить команду:  'java -jar ReactWebService.jar'

 Сервис будет доступен по адресу 'http://localhost:80/'  (Возможно нужно будет очистить кэш браузера)


## Разработка
 
Для динамической компиляции фронта выполнить команду в директории Frontend: 'npm start'. Запустится сервер с фронтом на
localhost:3000

Для разработки бэка, установить в IDE плагин Lombok

