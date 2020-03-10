USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS joiner;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
Alter table users add constraint uniq_user unique(username);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    type VARCHAR(240) NOT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE joiner (
  ad_id INT UNSIGNED NOT NULL,
  cat_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (ad_id) REFERENCES ads(id),
  FOREIGN KEY (cat_id) REFERENCES categories(id)
);