CREATE TABLE product
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT collate nocase NOT NULL,
    description     TEXT,
    type_id         INTEGER NOT NULL CONSTRAINT product_type_id_fk REFERENCES product_type (id),
    brand           TEXT,
    price           NUMERIC NOT NULL,
    color           TEXT,
    is_new          BOOLEAN,
    is_sales        BOOLEAN,
    main_image      INTEGER
);

CREATE INDEX product_type_id_index ON product (type_id);
