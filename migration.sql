USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS blocks;

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

CREATE TABLE categories
(   
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category     varchar(240)  NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE blocks (
                    id INT UNSIGNED NOT NULL  AUTO_INCREMENT,
                    block VARCHAR(240) NOT NULL
                    PRIMARY KEY (id) 
);

CREATE TABLE adsCategoriesBlocks
(
    ads_id INT UNSIGNED NOT NULL,
    blocks_id INT UNSIGNED NOT NULL,
    categories_id INT UNSIGNED NOT NULL,
     FOREIGN KEY (ads_id) REFERENCES ads (id)
        ON DELETE CASCADE,
     FOREIGN KEY (categories_id) REFERENCES categories (id)
        ON DELETE CASCADE,
      FOREIGN KEY (blocks_id) REFERENCES blocks (id)
        ON DELETE CASCADE
);        
  
        
  

