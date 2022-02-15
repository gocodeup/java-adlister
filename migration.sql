USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ad_category;

CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL UNIQUE,
    email    VARCHAR(240) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(240) NOT NULL,
    description TEXT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE categories
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ad_id INT UNSIGNED NOT NULL,
    categoryName VARCHAR(240) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
        ON DELETE CASCADE
);

CREATE TABLE ad_category
(
    category_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ad_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id)
        ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories(id)
);