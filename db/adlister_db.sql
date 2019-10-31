DROP TABLE IF EXISTS adlister_db; 

CREATE DATABASE adlister_db;

USE adlister_db;

CREATE TABLE users(
	id int(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username varchar(255) NOT NULL UNIQUE,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);

CREATE TABLE ads(
	id int(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    userId int(10) NOT NULL,
    title varchar(255) NOT NULL,
    category varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    username varchar(255)
);

CREATE TABLE categories(
    id int (20) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar (255) NOT NULL
)