DROP DATABASE IF EXISTS  `Ex1:Design a table`;
CREATE DATABASE `Ex1:Design a table`;
USE `Ex1:Design a table`;

DROP TABLE IF EXISTS `TRAINEE`; 
CREATE TABLE `TRAINEE` (
    TraineeID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(150),
    BirthDate DATE,
    Gender ENUM('nam', 'nu', 'gioi tinh thu 3'),
    ET_IQ INT CHECK (ET_IQ >= 0 && ET_IQ <= 20),	
    ET_Gmath INT CHECK (ET_Gmath >= 0 && ET_Gmath <= 20),
    ET_English INT CHECK (ET_English >= 0 && ET_English <= 50),
    ClassID INT,
    EvaluationNote TEXT
);

ALTER TABLE `TRAINEE` ADD VTIAccount VARCHAR(50) NOT NULL UNIQUE;

