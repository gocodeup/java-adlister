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
                        FOREIGN KEY (cat_id) REFERENCES categories (id)  ON DELETE CASCADE,
                        FOREIGN KEY (ad_id) REFERENCES ads (id)  ON DELETE CASCADE

);

CREATE TABLE ads_fav(
                        user_id INT UNSIGNED NOT NULL ,
                        ad_id INT UNSIGNED NOT NULL ,
                        FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
                        FOREIGN KEY (ad_id) REFERENCES ads (id) ON DELETE CASCADE
);



# USER PLANTS
INSERT INTO users (username, email, password) VALUES ('test', 'test@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Testy_Teserson', 'test1@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Alfred_testers', 'te1st@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Jaminican_teststrom', 't2est@test.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Tripp', 'tripp@tripperdipper.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Crystal', 'crystal@cssChamp.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e'),
                                                     ('Isaac', 'isaac@SlumLord.com', '$2a$12$Oc3m7XZ18EYOeUMemf.JXu0Aw2h7voI8I1UewpEq9VIH7Kdm6u08e');

INSERT INTO categories (category) VALUES ('Animals'),('Books'),('Sports/Games'),('Tools'),('Tourist'),
                                         ('Buildings'),('Cars'),('Celebrities'),('Celebrations'),('Cities')

                                       ,('Clothes'),('Comic book'),('Currencies'),('Drinks'),('Electronic goods'),
                                        ('Films'),('Film characters'),('Food'),('Football teams'),('Fruit'),

                                        ('Furniture'),('Hobbies'),('Hotels'),('Jobs'),('Languages'),
                                        ('Liquids'),('Mammals'),('Materials'),('Musical genres'),('Musical instruments'),

                                        ('Places to eat'),('School subjects'),('Shops'),('Singers/Bands'),('Sounds')
                                        ,('Toys'),('Vegetables'), ('Vehicles');


INSERT INTO ads (user_id, title, description) VALUES (1,'2 29"x45" Mirrors', '2 29"x45" Mirrors. Asking $20.00 each. I`m 22min. from Walmart in Bonsack. I deal in cash only');
INSERT INTO ads_cat (cat_id, ad_id) VALUES (21,1);

INSERT INTO ads (user_id, title, description) VALUES (2,'13 ANTIQUE CLOCKS', 'All of the great clocks you see pictured here are still available in beautiful Monroe NC so no need to ask. Each clock is in running condition although I do not run them all of the time. The individual ads for each clock can be found in Charlotte CL by searching "clock". Cash only please. Delivery and set up available. Email with a phone number, or call/text. Thanks for looking. Good luck');
INSERT INTO ads_cat (cat_id, ad_id) VALUES (21,2), (22,2);

INSERT INTO ads (user_id, title, description) VALUES (3,'AKAI Reel to Reel', 'AKAI Reel to Reel, GX280D-SS. I have a box of tape reels to go with it. Asking $200.00 Ideal in cash only.');
INSERT INTO ads_cat (cat_id, ad_id) VALUES (15,3), (22,3), (29,3), (30,3);

INSERT INTO ads (user_id, title, description) VALUES (4,'Antique pull chain toilet', 'Antique pull chain toilet bowl and tank. Don''t have any of the other hardware, just what you see in the photos. Asking $50.00 I deal in cash only.');
INSERT INTO ads_cat (cat_id, ad_id) VALUES (4,4), (28,4);

INSERT INTO ads (user_id, title, description) VALUES (5,'Reduced - ADIDAS TERREX Continental Hiking Shoes Men`s Size 10', 'Adidas TERREX Continental Sesame/Orange Hiking Shoes, Men`s Size US-10, Style G28407. Overall in outstanding condition with minor scuffing on toes. These shoes would be over $125 new. Adidas TERREX shoes for men and women are perfect for hiking or trekking with aggressive lug soles. These rugged lightweight shoes are the perfect footwear to enjoy maximum comfort while you make your routes.');
INSERT INTO ads_cat (cat_id, ad_id) VALUES (11,5), (22,5);


INSERT INTO ads_fav (user_id, ad_id) VALUES (1,2), (1,3);

#
# SELECT ads.id, ads.user_id, ads.title, ads.description FROM ads
#     JOIN ads_cat ac on ads.id = ac.ad_id
#     WHERE ads.id = 1 AND ac.cat_id = 1;
#
#
# SELECT DISTINCT ads.id, ads.user_id, ads.title, ads.description FROM ads WHERE
#     (title LIKE ? OR  description LIKE ?) AND
#         ads.id IN (SELECT ad_id FROM ads_cat WHERE cat_id ='21') AND
#         ads.id IN (SELECT ad_id FROM ads_cat WHERE cat_id ='22');

