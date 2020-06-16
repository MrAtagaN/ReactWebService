CREATE TABLE product
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT NOT NULL,
    description     TEXT,
    type_id         INTEGER NOT NULL CONSTRAINT product_type_id_fk REFERENCES product_type (id),
    sub_type        TEXT,
    brand           TEXT,
    price           NUMERIC NOT NULL,
    size            INTEGER,
    named_size      TEXT,
    color           TEXT,
    is_new          BOOLEAN,
    is_sales        BOOLEAN,

    CONSTRAINT product_name_unique UNIQUE (name)
);

CREATE INDEX product_type_id_index ON product (type_id);
