-- Search in a specific table the column that you want the value that you are change
DELIMITER $$

DROP PROCEDURE IF EXISTS GetRowByColumnValue;
CREATE PROCEDURE GetRowByColumnValue(
    IN SelectColumns VARCHAR(255),
    IN TableName VARCHAR(128),
    IN ColumnName VARCHAR(128),
    IN SearchValue VARCHAR(255)
    -- Comma-separated list of columns to select
)
BEGIN
    SET @query = CONCAT('SELECT ', SelectColumns,' FROM ', TableName , ' WHERE ', ColumnName , ' = ' , SearchValue);
    
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
DELIMITER ;





-- update a table with the condition that you want
DELIMITER $$
DROP PROCEDURE IF EXISTS UpdateRowByColumnValue;
CREATE PROCEDURE UpdateRowByColumnValue(
    IN TableName VARCHAR(128),
    IN UpdateColumns VARCHAR(255),
    IN ColumnName VARCHAR(128),
    IN SearchValue VARCHAR(255)
    -- Comma-separated list of columns to update with their value ex: UpdateColumns => column1 = value1, column2 = value2,
)
BEGIN
    SET @query = CONCAT('UPDATE ', TableName,' SET ', UpdateColumns , ' WHERE ', ColumnName , ' = ' , SearchValue);
    
    PREPARE stmt FROM @query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END $$
-- EX:  CALL UpdateRowByColumnValue("plane","capacity = 200","id","1");
DELIMITER ;