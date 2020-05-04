CREATE TABLE users
(
    id                      INTEGER PRIMARY KEY AUTOINCREMENT,
    username                TEXT NOT NULL,
    password                TEXT NOT NULL,
    account_non_expired     BOOLEAN NOT NULL,
    account_non_locked      BOOLEAN NOT NULL,
    credentials_non_expired BOOLEAN NOT NULL,
    enabled                 BOOLEAN NOT NULL,
    enter                   TIMESTAMP,
    last_enter              TIMESTAMP,
    creation_time           TIMESTAMP,
    email                   TEXT NOT NULL
);

