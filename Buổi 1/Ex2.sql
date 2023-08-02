DROP DATABASE IF EXISTS `Ex2: Data Types`;
CREATE DATABASE `Ex2: Data Types`;
USE`Ex2: Data Types`;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer (
	CustomerID INT auto_increment primary key,
    Name varchar(50),
    Code varchar(5),
	ModifiedDate DATE
);

