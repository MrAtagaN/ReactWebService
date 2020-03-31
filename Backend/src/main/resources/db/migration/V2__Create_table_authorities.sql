CREATE TABLE authorities
(
    user_id     INTEGER REFERENCES users (id),
    name        TEXT
);

CREATE INDEX authorities_user_id_index ON authorities (user_id);
--TODO add uniq
