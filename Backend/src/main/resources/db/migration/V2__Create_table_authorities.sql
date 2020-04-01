CREATE TABLE authorities
(
    user_id     INTEGER CONSTRAINT authorities_user_id_fk REFERENCES users (id),
    role        TEXT
);

CREATE INDEX authorities_user_id_index ON authorities (user_id);
