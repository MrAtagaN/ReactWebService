CREATE TABLE product_type
(
    id              INTEGER PRIMARY KEY AUTOINCREMENT,
    name            TEXT NOT NULL,
    gender          TEXT NOT NULL,
    age             TEXT NOT NULL,
    category        TEXT NOT NULL,

    CONSTRAINT product_type_name_category_unique UNIQUE (name, gender, age, category)
);

