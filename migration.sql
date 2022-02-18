USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ads_categories;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL UNIQUE,
    email VARCHAR(240) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(240) NOT NULL,
    description TEXT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);
# table to store category names being created
CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category VARCHAR(240) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);
# table for the categories each add can fit into
CREATE TABLE ads_categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ads_id INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ads_id) REFERENCES ads(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO categories (category) VALUES ('Automotive');
INSERT INTO categories (category) VALUES ('Clothing');
INSERT INTO categories (category) VALUES ('Electronics');
INSERT INTO categories (category) VALUES ('Furniture');
INSERT INTO categories (category) VALUES ('Home');
INSERT INTO categories (category) VALUES ('Tools');
INSERT INTO categories (category) VALUES ('Toys');
INSERT INTO categories (category) VALUES ('Miscellaneous');



# DROP DATABASE IF EXISTS adlister_db;
#
# CREATE DATABASE IF NOT EXISTS adlister_db;