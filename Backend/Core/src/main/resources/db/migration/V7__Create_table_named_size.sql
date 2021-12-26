CREATE TABLE named_size
(
    product_id      INTEGER CONSTRAINT named_size_product_id_fk REFERENCES product (id),
    name            TEXT
);

CREATE INDEX named_size_product_id_index ON named_size (product_id);