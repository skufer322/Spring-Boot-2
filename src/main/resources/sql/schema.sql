-- http://www.sqlines.com/online
DROP DATABASE IF EXISTS testdb;
CREATE DATABASE testdb;
USE testdb;

DROP TABLE IF EXISTS spring_modules;
CREATE TABLE spring_modules
(
    id   INT         NOT NULL IDENTITY,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name)
);
