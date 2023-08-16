DROP DATABASE IF EXISTS Extra6;
CREATE DATABASE Extra6;
USE Extra6;


CREATE TABLE Employee(
	EmployeeID TINYINT auto_increment primary key,
    EmployeeLastName varchar(20),
    EmployeeFirstName varchar(20),
    EmployeeHireDate DATE,
    EmployeeStatus varchar(30),
    SuperviorID TINYINT,
    SocialSecurityNumber INT
);



CREATE TABLE Projects (
	ProjectID TINYINT auto_increment primary key,
    ManagerID TINYINT,
    ProjectStartDate DATE,
    ProjectDescription varchar(150),
    ProjectDetail varchar(150),
    ProjectCompletedOn DATE
);



CREATE TABLE Project_Modules ( 
	ModuleID TINYINT auto_increment primary key,
    ProjectID TINYINT,
    EmployeeID TINYINT,
    ProjectModulesDate DATE,
	ProjectModulesCompletedOn DATE,
    ProjectModulesDescription varchar(150)
);




CREATE TABLE Work_Done(
	WorkDoneID TINYINT auto_increment primary key,
    EmployeeID TINYINT,
    ModuleID TINYINT,
    WorkDoneDate DATE DEFAULT NULL,
    WorkDoneDescription varchar(150),
    WorkDoneStatus TINYINT DEFAULT 0 CHECK ( WorkDoneStatus IN (0,1)),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
    FOREIGN KEY (ModuleID) REFERENCES Project_Modules(ModuleID)
);

DELETE FROM Projects WHERE ProjectCompletedOn IS NOT NULL AND DATEDIFF(NOW(), ProjectCompletedOn) >= 90;

INSERT INTO Employee (EmployeeLastName, EmployeeFirstName, EmployeeHireDate, EmployeeStatus, SuperviorID, SocialSecurityNumber)
VALUES
  ('Smith', 'John', '2023-01-15', 'Active', NULL, 123456789),
  ('Johnson', 'Anna', '2022-05-10', 'Active', 1, 987654321),
  ('Williams', 'Robert', '2023-03-20', 'Active', 1, 456789123),
  ('Brown', 'Emily', '2023-02-01', 'Active', 2, 789123456),
  ('Jones', 'Michael', '2022-11-05', 'Active', 3, 654321987);

INSERT INTO Projects (ManagerID, ProjectStartDate, ProjectDescription, ProjectDetail, ProjectCompletedOn)
VALUES
  (1, '2023-01-20', 'Project A', 'Details of Project A', NULL),
  (2, '2023-02-15', 'Project B', 'Details of Project B', NULL),
  (3, '2023-03-10', 'Project C', 'Details of Project C', NULL),
  (4, '2023-01-05', 'Project D', 'Details of Project D', '2023-01-15'),
  (5, '2023-02-10', 'Project E', 'Details of Project E', '2023-05-20');


INSERT INTO Project_Modules (ProjectID, EmployeeID, ProjectModulesDate, ProjectModulesCompletedOn, ProjectModulesDescription)
VALUES
  (1, 2, '2023-01-25', NULL, 'Module 1 of Project A'),
  (1, 3, '2023-02-01', NULL, 'Module 2 of Project A'),
  (2, 4, '2023-02-20', NULL, 'Module 1 of Project B'),
  (2, 5, '2023-02-25', NULL, 'Module 2 of Project B'),
  (3, 2, '2023-03-15', NULL, 'Module 1 of Project C');


INSERT INTO Work_Done (EmployeeID, ModuleID, WorkDoneDate, WorkDoneDescription, WorkDoneStatus)
VALUES
  (2, 1, '2023-01-26', 'Work done on Module 1 of Project A', 1),
  (3, 1, '2023-01-26', 'Work done on Module 1 of Project A', 1),
  (4, 3, '2023-02-21', 'Work done on Module 1 of Project B', 1),
  (5, 3, '2023-02-21', 'Work done on Module 1 of Project B', 1),
  (2, 5, '2023-03-20', 'Work done on Module 1 of Project C', 1);


-- Question 2 -- 

DROP PROCEDURE IF EXISTS RemoveOutProject;
DELIMITER //
	CREATE PROCEDURE RemoveOutProject ()
	BEGIN 
		DECLARE currentDate DATE;
		DECLARE NumProjectRemove INT;
        
        SET currentDate = CURDATE();
		
        DELETE FROM Projects WHERE ProjectCompletedOn >= ( currentDate - INTERVAL 3 MONTH);
        
        SET count_project = ROW_COUNT();
        
        SELECT CONCAT('Remove',count_project,'completed projects') AS Message;
        
        DELETE FROM Project_Modules
		WHERE ProjectID NOT IN (SELECT ProjectID FROM Projects);
        
    END//
DELIMITER ;

CALL RemoveOutProject();

-- Question 3 -- 
DROP PROCEDURE IF EXISTS  GetInProgressModules;
DELIMITER //
CREATE PROCEDURE GetInProgressModules()
BEGIN
    SELECT ModuleID, ProjectModulesDescription
    FROM Project_Modules
    WHERE ProjectModulesCompletedOn IS NULL;
END //
DELIMITER ;

CALL GetInProgressModules();

-- Question 4 -- 
DROP FUNCTION IF EXISTS GetUnassignedEmployeeWork;
DELIMITER \\
CREATE FUNCTION GetUnassignedEmployeeWork(employee_id_param TINYINT) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE work_count INT;
    SELECT COUNT(*) INTO work_count
    FROM Work_Done
    WHERE EmployeeID = employee_id_param AND ModuleID IS NULL;
    RETURN work_count;
END;

DELIMITER ;


SELECT GetUnassignedEmployeeWork(1); 

