DROP DATABASE IF EXISTS `Ex3: DATA TYPES(2)`;
CREATE DATABASE  `Ex3: DATA TYPES(2)`;
USE  `Ex3: DATA TYPES(2)`;

DROP DATABASE IF EXISTS Customer;
CREATE TABLE Customer (
	ID INT auto_increment primary key,
    Name VARCHAR(50),
    BirthDate DATE,
    Gender ENUM('nam', 'nu', 'khong xac dinh'),
    IsDeletedFlag BOOLEAN default 0
);