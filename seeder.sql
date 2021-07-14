use adlister_db;

INSERT INTO users (username, email, password)
VALUES ('bob-o', 'bobby@email.com', 'password'),
       ('sally-smith', 'sally@email.com', 'password');

INSERT INTO ads (user_id, title, description)
VALUES

(2, 'Super Soakers', 'Super Soaker is a brand of recreational water gun that utilizes manually-pressurized air to shoot water with greater power, range, and accuracy than conventional squirt pistols. The Super Soaker was invented in 1982 by engineer Lonnie Johnson. The prototype combined PVC pipe, acrylic glass, and an empty plastic soda bottle. - (https://en.wikipedia.org/wiki/Super_Soaker)'),

(2, 'Pogs', 'Pogs, generically called milk caps, is a game that was popular among children during the mid 1990s. - (https://en.wikipedia.org/wiki/Milk_caps_(game))'),

(1, 'The Word "Tubular"', 'Surfing (particularly in Southern California) has its own sociolect, which has comingled with Valleyspeak. Words such as "dude", "tubular", "radical", and "gnarly" are associated with both and Northern California created its own unique surf terms as well that include "groovy", "hella", and "tight". - (https://en.wikipedia.org/wiki/Surf_culture#Surf_terminology)'),

(1, 'Surge', 'Surge (sometimes styled as SURGE) is a citrus flavored soft drink first produced in the 1990s by The Coca-Cola Company to compete with Pepsi''s Mountain Dew. - (https://en.wikipedia.org/wiki/Surge_(drink))'),

(1, 'The Nintendo 64', 'The Nintendo 64 (Japanese: ニンテンドウ64 Hepburn: Nintendō Rokujūyon), stylized as NINTENDO64 and abbreviated to N64, is Nintendo''s third home video game console for the international market. Named for its 64-bit central processing unit, it was released in June 1996 in Japan, September 1996 in North America and Brazil, March 1997 in Europe and Australia, September 1997 in France. - (https://en.wikipedia.org/wiki/Nintendo_64)');

-- test comment for pull