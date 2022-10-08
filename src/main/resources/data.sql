CREATE TABLE person
(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    primary key(id)
);

INSERT INTO person
    (id, name, location, birth_date)
VALUES
    (10001, 'Durgaprasad', 'Bengaluru', current_timestamp);

INSERT INTO person
    (id, name, location, birth_date)
VALUES
    (10002, 'Akshatha', 'Bengaluru', current_timestamp);

INSERT INTO person
    (id, name, location, birth_date)
VALUES
    (10003, 'Mangala', 'Bengaluru', current_timestamp);

INSERT INTO person
    (id, name, location, birth_date)
VALUES
    (10004, 'Akshatha', 'Bengaluru', current_timestamp);