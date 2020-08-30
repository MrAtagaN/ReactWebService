CREATE TABLE user_registration_request
(
       id                      INTEGER PRIMARY KEY AUTOINCREMENT,
       username                TEXT NOT NULL,
       password                TEXT NOT NULL,
       creation_time           TIMESTAMP NOT NULL,
       email                   TEXT NOT NULL,
       confirm_code            TEXT NOT NULL,


       CONSTRAINT users_email_unique UNIQUE (email)
);


