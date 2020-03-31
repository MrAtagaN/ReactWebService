CREATE TABLE authorities
(
    user_id     integer REFERENCES users (id),
    name        text
);

CREATE INDEX authorities_user_id_index ON authorities (user_id);
--TODO add uniq
