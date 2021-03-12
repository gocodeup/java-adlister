USE adlister_db;

DROP TABLE IF EXISTS ad_images;
DROP TABLE IF EXISTS ad_category;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       INT UNSIGNED        NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) UNIQUE NOT NULL,
    email    VARCHAR(240) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
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

CREATE TABLE ad_images
(
    id    INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ad_id INT UNSIGNED NOT NULL,
    path  varchar(255) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
        ON DELETE CASCADE
);

CREATE TABLE categories
(
    id   INT UNSIGNED        NOT NULL AUTO_INCREMENT,
    name VARCHAR(240) UNIQUE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ad_category
(
    ad_id       INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);



INSERT INTO users (username, email, password)
VALUES ('Jeremy Telhiard', 'jeremy@gmail.com', '$2a$12$OO.hASBeuKXEOVtnD1RXtOdTpBkmAJGF9x.z2aY9IKhQEOjz91YUK'),
       ('Mike Greenburg', 'mike@hotmail.com', '$2a$12$MIleZjxgndLPLZKvPsgNf.flhDueV3mhsV4WwmEL48wwRXu8prwdC'),
       ('Anthony San Miguel', 'anthony@satx.rr.com', '$2a$12$OJvtZfs303H3YK.O.Muz6eriFkhqZHgkx2PE9d5Ve614pULuxwzga'),
       ('John Doe', 'john@yahoo.com', '$2a$12$UTSMlRS6lidTGQWdcLDDROkSF1iM9AlBtI7FG/QwXX/gPMk5ekfNC');

INSERT into ads (user_id, title, description)
VALUES (1, 'playstation for sale', 'This is a slightly used playstation'),
       (1, 'Super Nintendo', 'Get your game on with this old-school classic!'),
       (2, 'Junior Java Developer Position',
        'Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript'),
       (2, 'JavaScript Developer needed', 'Must have strong Java skills');

INSERT INTO categories (name)
VALUES ('service'),
       ('item'),
       ('help wanted');


INSERT INTO ad_images (ad_id, path)
VALUES (1,
        'https://www.thoughtco.com/thmb/5GsvhhtGRd64_-UOMeYly6ZTquE=/768x0/filters:no_upscale():max_bytes(150000)' ||
         ':strip_icc()/OriginalSonyPlayStation-5c2d3715c9e77c000192d75e.jpg');

INSERT INTO ad_category(ad_id, category_id)
VALUES (1, 2),
       (2, 2),
       (3, 3),
       (4, 3);

