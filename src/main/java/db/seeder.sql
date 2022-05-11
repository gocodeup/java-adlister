USE sa_lister_db;

INSERT INTO users (username, email, password)
VALUES ('Chris', 'chris@email.com', '$2a$12$PR.9ruxGJVsOfOGHCIYzl.JyA2CCxhMJXsosr2GTRM0exQPej3H/O'),
       ('Sam', 'sam@email.com', '$2a$12$PR.9ruxGJVsOfOGHCIYzl.JyA2CCxhMJXsosr2GTRM0exQPej3H/O'),
       ('Nathan', 'nathan@email.com', '$2a$12$PR.9ruxGJVsOfOGHCIYzl.JyA2CCxhMJXsosr2GTRM0exQPej3H/O');

INSERT INTO categories (category)
VALUES ('restaurant'),
       ('history'),
       ('outdoors'),
       ('family'),
       ('etc');

INSERT INTO ads (user_id, cat_id, title, description, location, reputation)
VALUES ('1', '1', 'Bunz', 'Local burger restaraunt with some of the best burgers in town.', '122 E Houston St, San Antonio, TX 78205', 0),
       ('1', '2', 'Witte Museum', 'The Witte Museum was established in 1926 and is located in Brackenridge Park in San Antonio, Texas. It is dedicated to telling the stories of Texas, from prehistory to the present.', '3801 Broadway, San Antonio, TX 78209', 0),
       ('2', '3', 'McAllister Park', 'Park located on the north side of San Antonio that is comprised of 713 acres. It is great for walking, biking, and even has a dog park.', '13102 Jones Maltsberger Rd, San Antonio, TX 78247', 0),
       ('3', '4', 'Pearl Brewery', 'The Pearl San Antonio is a district in the city with a rich history. Initially home to the Pearl Brewery, which operated from 1883 to 2001, the Pearl district offers shops, a twice-weekly farmers market, restaurants, apartments, an outdoor park area, the Culinary Institute of America, and the Hotel Emma.', 'The, Pearl Pkwy, San Antonio, TX 78215', 0),
       ('3', '5', 'Codeup', 'San Antonio''s premier coding academy.', '600 Navarro St #600, San Antonio, TX 78205', 0);
