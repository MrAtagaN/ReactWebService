--Users

INSERT INTO users (id, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, email)
values (1, 'admin', '$2a$10$nWq3jS4Xui7hMVz4L1dUVuRYzY8DQsfWUROmXA627yd.wjm/FrD5G', true, true, true, true, 'admin@gmail.com');
-- зашифрованный пароль 'admin'

INSERT INTO users (id, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, email)
values (2, 'user', '$2a$10$DPPNZFtJEqmVr8qpARZfvu4HbT2Sd1bj563TIgZ35A7JPVtZUZ5MG', true, true, true, true, 'user@gmail.com');
-- зашифрованный пароль 'user'

INSERT INTO authorities (user_id, role) values (1, 'ADMIN');
INSERT INTO authorities (user_id, role) values (1, 'USER');
INSERT INTO authorities (user_id, role) values (2, 'USER');


-- Продукты

INSERT INTO product (name, description, category, type, sub_type, brand, price, size, named_size, gender, age, color, is_new, is_sales)
values ('модель 123', 'джинсы классические, прямые', 'clothes', 'джинсы', null, 'gap', 4999, 32, null, 'male', 'adult', 'синие', true, false);
