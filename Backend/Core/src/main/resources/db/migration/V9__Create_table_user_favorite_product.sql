CREATE TABLE user_favorite_product
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id       INTEGER NOT NULL CONSTRAINT user_favorite_product_user_id_fk REFERENCES users (id) ON DELETE CASCADE,
    product_id    INTEGER NOT NULL CONSTRAINT user_favorite_product_product_id_fk REFERENCES product (id) ON DELETE CASCADE,

    CONSTRAINT user_favorite_product_user_id_product_id_unique UNIQUE (user_id, product_id)
);

CREATE INDEX user_favorite_product_user_id_index ON user_favorite_product (user_id);
CREATE INDEX user_favorite_product_product_id_index ON user_favorite_product (product_id);

