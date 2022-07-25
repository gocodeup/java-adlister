USE adlister_db;

INSERT INTO users (username, email, password)
VALUES ('admin', 'admin@adlister.com', 'password'),
       ('perry', 'theplatypus@platy.com', 'bigperry'),
       ('fineas', 'flynnthefinn@gmail.com', 'biggle'),
       ('pherb', 'catchthefletch@gmail.com', 'wiggle'),
       ('DrDoof', 'shmertzthedertz@aol.com', 'jiggle');

INSERT INTO ads (user_id, title, description)
VALUES (2,'Secret Codes', 'The secret codes that unlock all of the nuclear devices on the planet. Use with extreme caution'),
       (2, 'Platypus Enclosure', 'Lightly used enclosure perfect for your semi-aquatic friends. Smooth glass with grass and water interior'),
       (3, 'Awesome Coaster', 'Custom roller coaster, built to be the best one ever created'),
       (4, 'Alien Spaceship', 'Spaceship originally belonging to an alien. Comes with insturction in flying it.'),
       (5, 'Platypus Wanted', 'I want the head of a secret agent platypus on my desk by morning.');