INSERT INTO users (username, email, password)
VALUES ('Carrington Jones', 'cjones@gmail.com', 'cjpassword'),
       ('Juan Garcia', 'jgarcia@gmail.com', 'jgpassword'),
       ('Joseph Hopkins', 'jhopkins@gmail.com', 'jhpassword'),
       ('Hannah Paterka', 'hpaterka@gmail.com', 'hppassword');

-- needs id or user id????
-- make a cars specific table???
INSERT INTO ads (title, description, user_id)
VALUES ('Tesla', 'Model 3', 4),
       ('Dodge', 'Ram TRX', 2),
       ('Chevy', 'Apache', 3),
       ('Tesla', 'RunsOnGas&OnDiesel', 1);

-- we need to figure out how to tie categories to ads....
INSERT INTO categories (category)
VALUES ('sedans'),
       ('coupe'),
       ('trucks'),
       ('SUV'),
       ('vintage'),
       ('off-road'),
       ('utility'),
       ('vehicle parts');
