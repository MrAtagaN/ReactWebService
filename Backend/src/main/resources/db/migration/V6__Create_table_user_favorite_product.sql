CREATE TABLE user_favorite_product
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id         INTEGER CONSTRAINT user_favorite_product_user_id_fk REFERENCES users (id),
    product_id      INTEGER CONSTRAINT user_favorite_product_product_id_fk REFERENCES product (id)
);

CREATE INDEX user_favorite_product_user_id_index ON user_favorite_product (user_id);
CREATE INDEX user_favorite_product_product_id_index ON user_favorite_product (product_id);

--TODO добавить проверку уникальности  user_id и  product_id
