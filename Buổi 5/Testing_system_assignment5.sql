DROP DATABASE IF EXISTS Testing_System_Assignment_5;
CREATE DATABASE Testing_System_Assigment_5;
USE Testing_System_Assigment_5;

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


INSERT INTO Department (DepartmentName) VALUES
  ('HR'),
  ('Finance'),
  ('IT'),
  ('Marketing'),
  ('Sales'),
  ('Operations'),
  ('Research'),
  ('Legal'),
  ('Customer Service'),
  ('Production');


INSERT INTO `Position` (PositionName) VALUES
  ('Manager'),
  ('Engineer'),
  ('Analyst'),
  ('Designer'),
  ('Supervisor'),
  ('Coordinator'),
  ('Developer'),
  ('Assistant'),
  ('Specialist'),
  ('Technician');


INSERT INTO Account (Email, Username, FullName, DepartmentID, PositionID, CreateDate) VALUES
  ('user1@example.com', 'Nguyen Anh Vu', 'User One', 1, 2, NOW()),
  ('user2@example.com', 'Pham Minh Tuan', 'User Two', 2, 3, NOW()),
  ('user3@example.com', 'Pham Nhat Minh Khang', 'User Three', 3, 4, NOW()),
  ('user4@example.com', 'Quang Anh Tu', 'User Four', 4, 1, NOW()),
  ('user5@example.com', 'Vu Minh Nhat', 'User Five', 5, 2, NOW()),
  ('user6@example.com', 'Le Hoang Mai Anh', 'User Six', 1, 3, NOW()),
  ('user7@example.com', 'Tran Thi Hong Nhung', 'User Seven', 2, 4, NOW()),
  ('user8@example.com', 'Nguyen Truong Tho', 'User Eight', 3, 1, NOW()),
  ('user9@example.com', 'Pham Dinh Duy', 'User Nine', 4, 2, NOW()),
  ('user10@example.com', 'Do Ha o', 'Do Ha o', 5, 3, NOW());


INSERT INTO `Group` (GroupName, CreatorID, CreateDate) VALUES
  ('Group A', 1, '2017-04-23'),
  ('Group B', 2, NOW()),
  ('Group C', 3, NOW()),
  ('Group D', 4, NOW()),
  ('Group E', 5, NOW()),
  ('Group F', 6, NOW()),
  ('Group G', 7, NOW()),
  ('Group H', 8, NOW()),
  ('Group I', 9, NOW()),
  ('Group J', 10, NOW());


INSERT INTO GroupAccount (GroupID, AccountID, JoinDate) VALUES
  (1, 1, NOW()),
  (1, 2, NOW()),
  (2, 3, NOW()),
  (2, 4, NOW()),
  (5, 5, NOW()),
  (3, 6, NOW()),
  (4, 7, NOW()),
  (4, 8, NOW()),
  (5, 9, NOW()),
  (5, 10, NOW());


INSERT INTO TypeQuestion (TypeName) VALUES
  ('Multiple Choice'),
  ('Essay'),
  ('True/False'),
  ('Fill in the Blanks'),
  ('Matching');


INSERT INTO CategoryQuestion (CategoryName) VALUES
  ('Math'),
  ('Science'),
  ('History'),
  ('Literature'),
  ('Geography'),
  ('Art'),
  ('Music'),
  ('Sports'),
  ('Technology'),
  ('General Knowledge');


INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate) VALUES
  ('What is the square root of 64?', 1, 1, 1, '2023-05-04'),
  ('Describe the process of photosynthesis.', 2, 2, 2, '2020-04-01'),
  ('Who was the first President of the United States?', 3, 1, 3, '2023-03-02'),
  ('Name a famous Shakespeare play.', 4, 1, 4, '2018-07-09'),
  ('What is the capital of France?', 5, 1, 5, '2023-11-21'),
  ('Who painted the Mona Lisa?', 6, 1, 6, '2023-07-02'),
  ('Who composed the Symphony No. 9?', 7, 1, 7, '2023-08-12'),
  ('In which sport is the Stanley Cup awarded?', 8, 1, 8, '2023-08-11'),
  ('What is the purpose of a CPU?', 9, 1, 9, '2023-03-21'),
  ('What is the chemical symbol for gold?', 10, 1, 10, '2023-08-15');


INSERT INTO Answer (Content, QuestionID, isCorrect) VALUES
   ('8', 1, 1),     
  ('Photosynthesis is the process...', 2, 1),     
  ('George Washington', 3, 1),     
  ('Romeo and Juliet', 4, 1),     
  ('Paris', 5, 1),     
  ('Leonardo da Vinci', 6, 1),     
  ('Ludwig van Beethoven', 7, 1),    
  ('Hockey', 8, 1),    
  ('Central Processing Unit', 9, 1),     
  ('Au', 10, 1);     


INSERT INTO Exam (Code, Title, CategoryID, Duration, CreatorID, CreateDate) VALUES
  ('MATH101', 'Math Exam', 1, 60, 1, '2018-10-18'),
  ('SCI101', 'Science Exam', 2, 45, 2, NOW());


INSERT INTO ExamQuestion (ExamID, QuestionID) VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (2, 4),
  (2, 5),
  (1, 6),
  (1, 7),
  (2, 8),
  (2, 9),
  (1, 10);

-- Question 1 -- 
DROP VIEW SalesEmployees;


CREATE VIEW SalesEmployees AS
SELECT FullName, DepartmentID
FROM Account
WHERE DepartmentID = (
    SELECT DepartmentID
    FROM Department
    WHERE DepartmentName = 'Sales'
);


SELECT * FROM SalesEmployees;

-- QUESTION 2 --
CREATE VIEW MostGroupsAccount AS
SELECT
    a.AccountID,
    a.FullName,
    a.Email,
    (
        SELECT COUNT(*)
        FROM GroupAccount ga
        WHERE ga.AccountID = a.AccountID
    ) AS GroupCount
FROM
    Account a
ORDER BY
    GroupCount DESC;

SELECT * FROM MostGroupsAccount;

-- Question 3  -- 

CREATE VIEW LongContentQuestions AS
SELECT
    q.QuestionID,
    q.Content
FROM
    Question q
WHERE
    LENGTH(q.Content) > 300;
