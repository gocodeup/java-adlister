DROP TABLE IF EXISTS adlister_db; 

CREATE DATABASE adlister_db;

USE adlister_db;

CREATE TABLE users(
	id int(10) UNSIGNED NOT NULL PRIMARY KEY,
    username varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);

CREATE TABLE ads(
	id int(10) UNSIGNED NOT NULL PRIMARY KEY,
    userId int(10) NOT NULL,
    title varchar(255) NOT NULL,
    description varchar(255) NOT NULL
);

	