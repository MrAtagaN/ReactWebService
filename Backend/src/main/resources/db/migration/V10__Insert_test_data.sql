INSERT INTO users (id, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, email)
values (1, 'admin', '$2a$10$nWq3jS4Xui7hMVz4L1dUVuRYzY8DQsfWUROmXA627yd.wjm/FrD5G', true, true, true, true, 'admin@gmail.com' );
-- зашифрованный пароль admin

INSERT INTO authorities (user_id, role) values (1, 'ADMIN');

