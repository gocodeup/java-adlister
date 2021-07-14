

USE food_mood;

TRUNCATE users;

INSERT INTO users (username, email, password)
VALUES ('testUser', 'test@gmail.com','hashedpassed');

TRUNCATE ads;

INSERT INTO ads (user_id, title, description)
VALUES (1, 'TestTitle','TestDescription');

