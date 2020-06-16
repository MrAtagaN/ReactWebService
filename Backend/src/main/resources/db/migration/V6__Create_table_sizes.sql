CREATE TABLE sizes
(
    product_id      INTEGER CONSTRAINT size_product_id_fk REFERENCES product (id),
    value           INTEGER
);

CREATE INDEX size_product_id_index ON sizes (product_id);