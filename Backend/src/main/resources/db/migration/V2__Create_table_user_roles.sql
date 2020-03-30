CREATE TABLE user_roles
(
    user_id     bigint REFERENCES users (id),
    name        text
);

CREATE INDEX user_roles_user_id_index ON user_roles (user_id);
