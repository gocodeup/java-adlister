USE adlister_db;

INSERT INTO users (id, username, email, password) VALUES (1, 'test', 'test@test.com', 'test'); 

INSERT INTO ads (id, userId, title, category, description) VALUES (1, 1, 'ads title', 'category', 'ads description');

INSERT INTO users (id, username, email, password) VALUES (2, 'a', 'test@test.com', 'a');
