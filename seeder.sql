USE adlister_db;

# How to truncate a foreign key constrained table:
-- https://tombevers.me/2013/10/14/how-to-truncate-a-foreign-key-constrained-table/

SET FOREIGN_KEY_CHECKS=0;
TRUNCATE categories;
SET FOREIGN_KEY_CHECKS=1;

INSERT INTO categories (name)
    VALUES ('Community'),
           ('Services'),
           ('Housing'),
           ('For Sale'),
           ('Jobs');