DROP DATABASE IF EXISTS Assignment4 ;
CREATE DATABASE Assignment4;
USE  Assignment4; 

DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	Department_Number TINYINT AUTO_INCREMENT PRIMARY KEY,
    Department_Name varchar(50)    
);


DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
	Employee_Number TINYINT AUTO_INCREMENT PRIMARY KEY ,
    Employee_Name varchar(50), 
    Department_Number TINYINT ,
    FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)
 );   

DROP TABLE IF EXISTS Employee_Skill ;
CREATE TABLE Employee_Skill (
	Employee_Number TINYINT,
    Skill_Code varchar(50), 
    Date_Registered DATE,
	FOREIGN KEY (Employee_Number) REFERENCES Employee(Employee_Number)
);



INSERT INTO Department (Department_Name)
VALUES
    ('HR'),
    ('IT'),
    ('Finance'),
    ('Marketing'),
    ('Sales');

INSERT INTO Employee (Employee_Name, Department_Number)
VALUES
    ('John Doe', 1),
    ('Jane Smith', 2),
    ('Michael Johnson', 3),
    ('Emily Williams', 2),
    ('David Brown', 5),
    ('Sarah Davis', 1),
    ('Robert Wilson', 2),
    ('Karen Miller', 3),
    ('Richard Lee', 1),
    ('Michelle Martinez', 5);


INSERT INTO Employee_Skill (Employee_Number, Skill_Code, Date_Registered)
VALUES
    (1, 'Coding', '2023-08-12'),
    (2, 'Database Management', '2023-08-11'),
    (3, 'Java', '2023-08-10'),
    (4, 'PHP', '2023-08-09'),
    (5, 'Sales Techniques', '2023-08-08'),
    (6, 'NodeJS', '2023-08-07'),
    (7, 'Javascripts', '2023-08-06'),
    (8, 'Data Analysis', '2023-08-05'),
    (9, 'Project Management', '2023-08-04'),
    (10, 'Leadership', '2023-08-03'),
    (3, 'java', '2019-05-20');

-- Question 2 -- 
SELECT Employee_Name 
FROM Employee AS t1 
JOIN Employee_Skill AS t2 
ON t1.Employee_Number = t2.Employee_Number  
WHERE t2.Skill_Code = 'java'
UNION 
SELECT E.Employee_Name
FROM Employee E
JOIN Employee_Skill ES ON E.Employee_Number = ES.Employee_Number
WHERE ES.Skill_Code = 'Java';


-- Question 3 -- 

SELECT Department_Name, COUNT(t2.Employee_Number) AS so_luong
FROM Department t1
JOIN Employee t2 ON t1.Department_Number = t2.Department_Number
GROUP BY Department_Name
HAVING so_luong > 2; 

-- Question 4 -- 

SELECT  Department_Name, GROUP_CONCAT(E.Employee_Name ) AS Employee_List 
FROM Employee as E 
JOIN Department as D 
ON E.Department_Number = D.Department_Number 
GROUP BY D.Department_Name;

-- QUESTION 6 -- 
SELECT Employee_Name, GROUP_CONCAT(DISTINCT ES.Skill_Code) as skill,  COUNT(ES.Employee_Number) AS so_Luong from Employee as E JOIN Employee_Skill as ES ON E.Employee_Number = ES.Employee_Number GROUP BY E.Employee_Name HAVING so_luong > 1;