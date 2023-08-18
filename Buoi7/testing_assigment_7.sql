DROP DATABASE IF EXISTS Testing_System_Assignment_7;
CREATE DATABASE Testing_System_Assigment_7;
USE Testing_System_Assigment_7;

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
  Gender varchar(20),
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


-- Question 1: Trigger not allowing users to input Groups created more than 1 year ago
DELIMITER //
CREATE TRIGGER check_group_create_date
BEFORE INSERT ON `Group` FOR EACH ROW
BEGIN
  IF NEW.CreateDate <= DATE_SUB(NOW(), INTERVAL 1 YEAR) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot create a Group older than 1 year.';
  END IF;
END;
//
DELIMITER ;

-- Question 2: Trigger not allowing users to add more users to the "Sales" department
DELIMITER //
CREATE TRIGGER prevent_sales_department_user_add
BEFORE INSERT ON Account FOR EACH ROW
BEGIN
  DECLARE dept_name VARCHAR(255);
  SELECT DepartmentName INTO dept_name FROM Department WHERE DepartmentID = NEW.DepartmentID;
  IF dept_name = 'Sales' THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Department "Sales" cannot add more users.';
  END IF;
END;
//
DELIMITER ;

-- Question 3: Trigger allowing a maximum of 5 users per group
DELIMITER //
CREATE TRIGGER limit_group_users
BEFORE INSERT ON GroupAccount FOR EACH ROW
BEGIN
  DECLARE user_count INT;
  SELECT COUNT(*) INTO user_count FROM GroupAccount WHERE GroupID = NEW.GroupID;
  IF user_count >= 5 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Maximum number of users reached for this group.';
  END IF;
END;
//
DELIMITER ;

-- Question 4: Trigger allowing a maximum of 10 questions per exam
DELIMITER //
CREATE TRIGGER limit_exam_questions
BEFORE INSERT ON ExamQuestion FOR EACH ROW
BEGIN
  DECLARE question_count INT;
  SELECT COUNT(*) INTO question_count FROM ExamQuestion WHERE ExamID = NEW.ExamID;
  IF question_count >= 10 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Maximum number of questions reached for this exam.';
  END IF;
END;
//
DELIMITER ;

-- Question 5
DELIMITER //
CREATE TRIGGER prevent_admin_account_deletion
BEFORE DELETE ON Account FOR EACH ROW
BEGIN
  IF OLD.Email = 'admin@gmail.com' THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot delete the admin account.';
  END IF;
END;
//
DELIMITER ;

-- Question 6
DELIMITER //
CREATE TRIGGER assign_waiting_department
BEFORE INSERT ON Account FOR EACH ROW
BEGIN
  IF NEW.DepartmentID IS NULL THEN
    SET NEW.DepartmentID = (SELECT DepartmentID FROM Department WHERE DepartmentName = 'waiting Department');
  END IF;
END;
//
DELIMITER ;

-- Question 7
DELIMITER //
CREATE TRIGGER limit_question_answers
BEFORE INSERT ON Answer FOR EACH ROW
BEGIN
  DECLARE answer_count INT;
  DECLARE correct_answer_count INT;
  SELECT COUNT(*) INTO answer_count FROM Answer WHERE QuestionID = NEW.QuestionID;
  SELECT COUNT(*) INTO correct_answer_count FROM Answer WHERE QuestionID = NEW.QuestionID AND isCorrect = 1;
  
  IF answer_count >= 4 OR correct_answer_count >= 2 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Maximum number of answers or correct answers reached for this question.';
  END IF;
END;
//
DELIMITER ;

-- Question 8
DELIMITER //
CREATE TRIGGER standardize_gender
BEFORE INSERT ON Account FOR EACH ROW
BEGIN
  IF NEW.Gender = 'nam' THEN
    SET NEW.Gender = 'M';
  ELSEIF NEW.Gender = 'nữ' THEN
    SET NEW.Gender = 'F';
  ELSEIF NEW.Gender = 'chưa xác định' THEN
    SET NEW.Gender = 'U';
  END IF;
END;
//
DELIMITER ;

-- Question 9
DELIMITER //
CREATE TRIGGER prevent_recent_exam_deletion
BEFORE DELETE ON Exam FOR EACH ROW
BEGIN
  IF OLD.CreateDate >= DATE_SUB(NOW(), INTERVAL 2 DAY) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot delete an exam created within the last 2 days.';
  END IF;
END;
//
DELIMITER ;

-- Question 10
DELIMITER //
CREATE TRIGGER prevent_question_in_exam_update_delete
BEFORE UPDATE ON Question FOR EACH ROW
BEGIN
  IF EXISTS (SELECT * FROM ExamQuestion WHERE QuestionID = OLD.QuestionID) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Cannot update/delete a question that is in an exam.';
  END IF;
END;
//
DELIMITER ;

-- Question 12
DELIMITER //
CREATE TRIGGER modify_exam_duration
BEFORE INSERT ON Exam FOR EACH ROW
BEGIN
  IF NEW.Duration <= 30 THEN
    SET NEW.Duration = 'Short time';
  ELSEIF NEW.Duration <= 60 THEN
    SET NEW.Duration = 'Medium time';
  ELSE
    SET NEW.Duration = 'Long time';
  END IF;
END;
//
DELIMITER ;

-- Question 13
DELIMITER //
CREATE TRIGGER calculate_group_users_amount
AFTER INSERT ON GroupAccount FOR EACH ROW
BEGIN
  UPDATE `Group` 
  SET the_number_user_amount = 
    CASE 
      WHEN (SELECT COUNT(*) FROM GroupAccount WHERE GroupID = g.GroupID) <= 5 THEN 'few'
      WHEN (SELECT COUNT(*) FROM GroupAccount WHERE GroupID = g.GroupID) <= 20 THEN 'normal'
      ELSE 'higher'
    END;
END;
//
DELIMITER ;

-- Question 14
DELIMITER //
CREATE TRIGGER calculate_department_user_count
AFTER INSERT ON Account FOR EACH ROW
BEGIN
  UPDATE Department d
  SET UserCount = (SELECT COUNT(*) FROM Account WHERE DepartmentID = d.DepartmentID);
END;
//
DELIMITER ;


