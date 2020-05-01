CREATE TABLE product
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT NOT NULL,
    description     TEXT,
    category        TEXT NOT NULL,
    type            TEXT NOT NULL,
    sub_type        TEXT,
    brand           TEXT,
    price           NUMERIC NOT NULL,
    size            INTEGER,
    named_size      TEXT,
    gender          TEXT,
    age             TEXT,
    color           TEXT,
    is_new          BOOLEAN,
    is_sales        BOOLEAN
);


