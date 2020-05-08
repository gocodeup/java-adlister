USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email    VARCHAR(240) NOT NULL,
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


