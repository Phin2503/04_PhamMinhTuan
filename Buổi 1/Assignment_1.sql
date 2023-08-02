DROP DATABASE IF exists Testing_System_Assignment_1;
CREATE DATABASE Testing_System_Assigment_1;
USE Testing_System_Assigment_1;

DROP TABLE IF exists Department;
CREATE TABLE Department (
  DepartmentID INT auto_increment PRIMARY KEY,
  DepartmentName VARCHAR(255) NOT NULL
);

DROP TABLE IF exists `Position`;
CREATE TABLE `Position` (
  PositionID INT auto_increment  PRIMARY KEY,
  PositionName VARCHAR(255) NOT NULL
);

DROP TABLE IF exists Account;
CREATE TABLE Account (
  AccountID INT auto_increment PRIMARY KEY,
  Email VARCHAR(255) NOT NULL,
  Username VARCHAR(255) NOT NULL,
  FullName VARCHAR(255) NOT NULL,
  DepartmentID INT,
  PositionID INT,
  CreateDate DATE,
  FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
  FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

DROP TABLE IF exists `Group`;
CREATE TABLE `Group`(
  GroupID INT  auto_increment PRIMARY KEY,
  GroupName VARCHAR(255) NOT NULL,
  CreatorID INT,
  CreateDate DATE,
  FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);

DROP TABLE IF exists GroupAccount;
CREATE TABLE GroupAccount (
  GroupID INT,
  AccountID INT,
  JoinDate DATE,
  PRIMARY KEY (GroupID, AccountID),
  FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
  FOREIGN KEY (AccountID) REFERENCES Account(AccountID)
);


CREATE TABLE TypeQuestion (
  TypeID INT auto_increment  PRIMARY KEY,
  TypeName VARCHAR(255) NOT NULL
);


CREATE TABLE CategoryQuestion (
  CategoryID INT AUTO_INCREMENT PRIMARY KEY,
  CategoryName VARCHAR(255) NOT NULL
);


CREATE TABLE Question (
  QuestionID INT AUTO_INCREMENT PRIMARY KEY,
  Content TEXT NOT NULL,
  CategoryID INT,
  TypeID INT,
  CreatorID INT,
  CreateDate DATE,
  FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
  FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
  FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);


CREATE TABLE Answer (
  AnswerID INT auto_increment  PRIMARY KEY,
  Content TEXT NOT NULL,
  QuestionID INT,
  isCorrect BOOLEAN,
  FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);


CREATE TABLE Exam (
  ExamID INT auto_increment  PRIMARY KEY,
  Code VARCHAR(255) NOT NULL,
  Title VARCHAR(255) NOT NULL,
  CategoryID INT,
  Duration INT,
  CreatorID INT,
  CreateDate DATE,
  FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion(CategoryID),
  FOREIGN KEY (CreatorID) REFERENCES Account(AccountID)
);


CREATE TABLE ExamQuestion (
  ExamID INT,
  QuestionID INT,
  PRIMARY KEY (ExamID, QuestionID),
  FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
  FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);


