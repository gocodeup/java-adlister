USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;

CREATE TABLE users (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email VARCHAR(240) NOT NULL,
    password VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE categories (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    description VARCHAR (50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    title VARCHAR(500) NOT NULL,
    description TEXT NOT NULL,
    photo VARCHAR(900),
    category INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (category) REFERENCES categories(id)
);


INSERT INTO users (username, email, password) VALUES
            ('Shaz', 'shaz@codeup.com', 'codeup-1'),
            ('Luis', 'luis@codeup.com', 'codeup-1'),
            ('Kaylah', 'kaylah@codeup.com', 'codeup-1'),
            ('User1', 'user1@codeup.com', 'codeup-1'),
            ('User2', 'user2@codeup.com', 'codeup-1'),
            ('User3', 'user3@codeup.com', 'codeup-1');

INSERT INTO categories (id, description) VALUES
            (1, 'shoes'),
            (2, 'shirts'),
            (3, 'pants'),
            (4, 'outerwear'),
            (5, 'accessories'),
            (6, 'hats');

INSERT INTO ads (user_id, title, description, photo, category) VALUES
            (1, 'Doc Martens for sale', 'Selling brand new never worn Doc Marten boots', 'https://i.guim.co.uk/img/media/ac1c53dc8a3b549480149d041e9299097cb39955/0_302_1600_960/master/1600.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=72a96ac2a6a11b027782df30148181e9', 1),
            (1, 'Stetson Hat', 'Lightly used stetson hat for sale', 'https://cdn.nudiejeans.com/img/Western-Hat-Brown-180998B10-01_1600x1600.jpg', 6),
             (2, 'Wrangler Jeans', 'Lightly used wrangler jeans for sale. Size 32x30.', 'https://media.kohlsimg.com/is/image/kohls/1692397_Dark_Denim?wid=600&hei=600&op_sharpen=1', 3),
              (3, 'Cowboy boots', 'Boots for sale size 10', 'https://m.media-amazon.com/images/I/811VSTCeOPL._AC_UY500_.jpg', 1),
            (4, 'White Shirt', 'White button-up shirt in great condition. Size medium', 'https://m.media-amazon.com/images/I/51jeA4UDYHL._AC_UL1200_.jpg', 2),
            (5, 'White t-shirt', 'Never worn large white t-shirt', 'https://www.gap.com/webcontent/0020/581/516/cn20581516.jpg', 2);




