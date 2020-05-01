CREATE TABLE user_bag_product
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id       INTEGER CONSTRAINT user_bag_product_user_id_fk REFERENCES users (id),
    product_id    INTEGER CONSTRAINT user_bag_product_product_id_fk REFERENCES product (id)
);

CREATE INDEX user_bag_product_user_id_index ON user_bag_product (user_id);
CREATE INDEX user_bag_product_product_id_index ON user_bag_product (product_id);
