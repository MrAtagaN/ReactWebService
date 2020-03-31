CREATE TABLE users
(
    id                      INTEGER PRIMARY KEY AUTOINCREMENT,
    username                text,
    password                text,
    account_non_expired     boolean,
    account_non_locked      boolean,
    credentials_non_expired boolean,
    enabled                 boolean,
    last_enter              timestamp
);

