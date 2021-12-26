CREATE TABLE image
(
    product_id      INTEGER CONSTRAINT image_product_id_fk REFERENCES product (id) ON DELETE CASCADE,
    data            BLOB,
    images_ORDER    INTEGER
);

CREATE INDEX image_product_id_index ON image (product_id);

