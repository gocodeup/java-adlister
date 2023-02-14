DROP DATABASE IF EXISTS adlister_db;
CREATE DATABASE adlister_db;
USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (username),
    UNIQUE (email)
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

CREATE TABLE categories(
                           id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                           category VARCHAR(20) NOT NULL,
                           PRIMARY KEY (id)
);

CREATE TABLE ads_cat(
                        cat_id INT UNSIGNED NOT NULL ,
                        ad_id INT UNSIGNED NOT NULL ,
                        FOREIGN KEY (cat_id) REFERENCES categories (id),
                        FOREIGN KEY (ad_id) REFERENCES ads (id)
);

CREATE TABLE ads_fav(
                        user_id INT UNSIGNED NOT NULL ,
                        ad_id INT UNSIGNED NOT NULL ,
                        FOREIGN KEY (user_id) REFERENCES users (id),
                        FOREIGN KEY (ad_id) REFERENCES ads (id)
);



# USER PLANTS
INSERT INTO users (username, email, password) VALUES ('test', 'test@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Testy_Teserson', 'test1@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Alfred_testers', 'te1st@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Jaminican_teststrom', 't2est@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Tripp', 'tripp@tripperdipper.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Crystal', 'crystal@cssChamp.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Isaac', 'isaac@SlumLord.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e');

INSERT INTO categories (category) VALUES ('Animals'),('Adjectives'),('Adverbs'),('Birds'),('Books'),('Buildings'),('Cars'),('Celebrities'),('Celebrations'),('Cities')
                                       ,('Clothes'),('Comic book'),('Currencies'),('Drinks'),('Electronic goods'),('Films'),('Film characters'),('Food'),('Football teams')
                                       ,('Fruit'),('Furniture'),('Hobbies'),('Hotels'),('Jobs'),('Languages'),('Liquids'),('Mammals'),('Materials'),('Musical genres')
                                       ,('Musical instruments'),('Places to eat'),('School subjects'),('Shops'),('Singers/Bands'),('Sounds'),('Sports/Games'),('Tools')
                                       ,('Tourist'),('Toys'),('Vegetables'),('Vehicles');
