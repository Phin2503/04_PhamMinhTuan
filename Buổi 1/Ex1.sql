DROP DATABASE IF EXISTS  `Ex1:Design a table`;
CREATE DATABASE `Ex1:Design a table`;
USE `Ex1:Design a table`;

DROP TABLE IF EXISTS `Fresher_management`; 
CREATE TABLE `Fresher_management` (
    TraineeID INT AUTO_INCREMENT PRIMARY KEY,
    FullName VARCHAR(150),
    BirthDate DATE,
    Gender ENUM('nam', 'nu', ''),
    ET_IQ tinyint CHECK (ET_IQ >= 0 && ET_IQ <= 20),	
    ET_Gmath tinyint CHECK (ET_Gmath >= 0 && ET_Gmath <= 20),
    ET_English tinyint CHECK (ET_English >= 0 && ET_English <= 50),
    ClassID tinyint,
    EvaluationNote TEXT
);

ALTER TABLE `Fresher_management` ADD VTIAccount VARCHAR(50) NOT NULL UNIQUE;


INSERT INTO `Fresher_management` (FullName, BirthDate, Gender , ET_IQ , ET_Gmath , ET_English , ClassID, EvaluationNote , VTIAccount) VALUES 
	('Pham Minh Tuan', '1990-05-15', 'nam', 12, 15, 23, 1, 'Good', 'phamminhtuan.vti'),
    ('Tuan Pham Minh', '1992-08-25', 'nu', 12, 15, 44, 1, 'Good', 'tuanphamminh.vti'),
    ('Minh Tuan Pham', '1991-03-10', 'nam', 19, 17, 42, 2, 'Good', 'minhtuanpham.vti'),
    ('Pham Tuan Minh', '1993-11-05', 'nu', 14, 13, 38, 2, 'Good', 'phamtuanminh.vti'),
    ('Minh Pham Tuan', '1994-07-20', 'nam', 16, 12, 42, 1, 'Bad', 'minhphamtuan.vti'),
    ('Bui Quang Long', '1995-01-18', 'nu', 10, 11, 30, 2, 'Good', 'buiquanglong.vti'),
    ('Pham Khiet Minh', '1992-09-08', 'nam', 18, 19, 47, 2, 'Good', 'phamkhietminh.vti'),
    ('Vu Nhat Long', '1991-06-30', 'nu', 17, 16, 32, 1, 'Good', 'vunhatlong.vti'),
    ('Nguyen Minh Nhat', '1993-04-12', 'nam', 13, 14, 32, 1, 'Bad', 'nguyenminhnhat.vti'),
    ('Vo Hoai An', '1994-12-28', 'nu', 11, 13, 8, 2, 'Bad', 'vohoaian.vti');


