USE adlister_db;

INSERT INTO users (id, username, email, password) VALUES (1, 'test', 'test@test.com', 'test'); 

INSERT INTO ads (id, userId, title, description) VALUES (1, 1, 'ads title', 'ads description');