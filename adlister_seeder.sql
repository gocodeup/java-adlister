
TRUNCATE table ads;
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE table users;
SET FOREIGN_KEY_CHECKS = 1;


INSERT INTO users(username, email, password) VALUES
('MikuHatsune', 'worldismine@email.com', '$2a$12$Ji/mV8KYcSht5MQyEFC.yOQGyOuXPoU.c8bBBVqS/UQd87/SKwAUK'),
('Yimothy', 'yimothy@yahoo.net', '$2a$12$33kjPr4iufbum3L37BLO6.nkLBqOplFO1AQTYGN7O0KqW4diamYSC');

INSERT INTO ads (user_id, title, description, img_url, gender, price, age) VALUES
(1, 'Dog', 'I dont know what it is', 'https://static.wikia.nocookie.net/warner-bros-entertainment/images/e/e5/Courage_cartoon_network.png','male',1, 20),
(1, 'Cat', 'Dont eat', 'https://upload.wikimedia.org/wikipedia/en/thumb/e/ed/Nyan_cat_250px_frame.PNG/220px-Nyan_cat_250px_frame.PNG', 'unknown', 100, 12);


