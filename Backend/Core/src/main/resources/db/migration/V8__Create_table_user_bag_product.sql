CREATE TABLE user_bag_product
(
    user_id       INTEGER NOT NULL CONSTRAINT user_bag_product_user_id_fk REFERENCES users (id) ON DELETE CASCADE,
    product_id    INTEGER NOT NULL CONSTRAINT user_bag_product_product_id_fk REFERENCES product (id) ON DELETE CASCADE,
    count         INTEGER,

    CONSTRAINT user_bag_product_user_id_product_id_unique UNIQUE (user_id, product_id)
);

CREATE INDEX user_bag_product_user_id_index ON user_bag_product (user_id);
CREATE INDEX user_bag_product_product_id_index ON user_bag_product (product_id);
