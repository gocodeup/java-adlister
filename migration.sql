USE
adlister_db;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL UNIQUE,
    email    VARCHAR(240) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id) # added these ND
        # maybe only dateCreated could be added
        # UNIQUE is identified in username/email above
        # will comment out until okayed by team
        # dateCreated VARCHAR (50) NOT NULL
        # UNIQUE (username),
    # UNIQUE (email)

);

DROP TABLE IF EXISTS ads;
CREATE TABLE ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(240) NOT NULL,
    description VARCHAR(400) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
        ON DELETE CASCADE

-- # added these ND

        # commenting out the below,
    # don't believe is needed
        # will discuss with team
        # dateCreated VARCHAR (50) NOT NULL,
    #           categoryName VARCHAR(255) NOT NULL,
    # UNIQUE (user_id, title, description)
);

DROP TABLE IF EXISTS categories;
CREATE TABLE categories
(
    id           INT UNSIGNED NOT NULL AUTO_INCREMENT,
    categoryName VARCHAR(240) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS ad_category;
CREATE TABLE ad_category
(
    category_id INT UNSIGNED NOT NULL,
    ad_id       INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads (id)
        ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

#
# Below INSERT should be removed
# Have seeder file for INSERT of categories
# Commenting out until discussed with team
# INSERT INTO categories (categoryName) VALUES
#               (''for sale''),
#               (''automotive''),
#               (''jobs''),
#               (''community''),
#               (''furniture'');