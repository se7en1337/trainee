CREATE TABLE persons
(
    id             int NOT NULL,
    firstname      varchar(255),
    surname        varchar(255),
    dateOfBirthday DATE,
    PRIMARY KEY (id)
);
INSERT INTO persons (id, firstname, surname, dateOfBirthday)
VALUES (1, 'Oleg', 'Leonov', '2002-09-06'),
       (2, 'Max', 'Toryanik', '2003-08-16'),
       (3, 'Anton', 'Kruglov', '2002-06-06');
