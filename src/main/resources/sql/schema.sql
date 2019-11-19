CREATE TABLE spring_modules
(
    id   INT         NOT NULL IDENTITY,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name)
);
