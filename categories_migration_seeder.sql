CREATE TABLE categories(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    category VARCHAR (40) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO categories (category)
VALUES ("Automotive"),
       ("Beauty and Health"),
       ("Books"),
       ("Clothing"),
       ("Computers"),
       ("Electronics"),
       ("Home and Garden"),
       ("Movies, Music, Games"),
       ("Outdoors"),
       ("Pets"),
       ("Sports");




CREATE TABLE ad_cat(
    ad_id INT UNSIGNED NOT NULL,
    cat_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (ad_id) REFERENCES ads(id),
    FOREIGN KEY (cat_id) REFERENCES categories(id)
);
