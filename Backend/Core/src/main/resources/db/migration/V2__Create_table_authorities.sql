CREATE TABLE authorities
(
    user_id     INTEGER CONSTRAINT authorities_user_id_fk REFERENCES users (id),
    authority        TEXT,

    CONSTRAINT authorities_user_id_role_unique UNIQUE (user_id, authority)
);

CREATE INDEX authorities_user_id_index ON authorities (user_id);

