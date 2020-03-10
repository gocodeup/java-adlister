DROP DATABASE IF EXISTS adlister_db;
CREATE DATABASE adlister_db;

USE adlister_db;

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
    cat_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    type VARCHAR(240) NOT NULL,
#     ad_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE joiner (
                        ad_id INT UNSIGNED NOT NULL,
                        cat_id INT UNSIGNED NOT NULL,
                        FOREIGN KEY (ad_id) REFERENCES ads(id),
                        FOREIGN KEY (cat_id) REFERENCES categories(id)
);

insert into categories (id, type) values (1, 'Cars');
insert into categories (id, type) values (2, 'Home Goods');
# insert into categories (id, type, ad_id) values (3, 'Services', ad_id);
# insert into categories (id, type, ad_id) values (4, 'Arts', ad_id);


