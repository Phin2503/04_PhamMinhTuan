DELIMITER //
CREATE TRIGGER Check_Module_Dates
BEFORE INSERT ON Project_Modules
FOR EACH ROW
BEGIN
    DECLARE ProjectStartDate DATE;
    DECLARE ProjectCompletedOn DATE;

    SELECT ProjectStartDate, ProjectCompletedOn
    INTO ProjectStartDate, ProjectCompletedOn
    FROM Projects
    WHERE ProjectID = NEW.ProjectID;

    IF (NEW.ProjectModulesDate < ProjectStartDate) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid Module Date: Project module start date cannot be before project start date';
    END IF;

    IF (NEW.ProjectModulesCompletedOn > ProjectCompletedOn) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid Module Date: Project module completion date cannot be after project completion date';
    END IF;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER Check_Module_Dates_Update
BEFORE UPDATE ON Project_Modules
FOR EACH ROW
BEGIN
    DECLARE ProjectStartDate DATE;
    DECLARE ProjectCompletedOn DATE;

    SELECT ProjectStartDate, ProjectCompletedOn
    INTO ProjectStartDate, ProjectCompletedOn
    FROM Projects
    WHERE ProjectID = NEW.ProjectID;

    IF (NEW.ProjectModulesDate < ProjectStartDate) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid Module Date: Project module start date cannot be before project start date';
    END IF;

    IF (NEW.ProjectModulesCompletedOn > ProjectCompletedOn) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid Module Date: Project module completion date cannot be after project completion date';
    END IF;
END;
//
DELIMITER ;


-- Question2 -- 


CREATE VIEW ET AS
SELECT *
FROM `Fresher_management` 
WHERE position = 'ET'
  AND (ET_IQ + ET_Gmath) >= 20
  AND ET_IQ >= 8
  AND ET_Gmath >= 8
  AND ET_English >= 18;

