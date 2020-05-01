CREATE TABLE product_type
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT NOT NULL,
    category        TEXT NOT NULL
);

--TODO добавить проверку на уникальность
