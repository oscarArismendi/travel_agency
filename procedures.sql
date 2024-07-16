-- Search in a specific table the column that you want the value of a string
DELIMITER $$

DROP PROCEDURE IF EXISTS GetRowByColumnValueString;
CREATE PROCEDURE GetRowByColumnValueString
    @TableName VARCHAR(128),
    @ColumnName VARCHAR(128),
    @SearchValue VARCHAR(255)
AS
BEGIN
    DECLARE @SQL VARCHAR(MAX);
    SET @SQL = 'SELECT * FROM ' + QUOTENAME(@TableName) + ' WHERE ' + QUOTENAME(@ColumnName) + ' = @SearchValue';
    
    EXEC sp_executesql @SQL, N'@SearchValue VARCHAR(255)', @SearchValue;
    DEALLOCATE PREPARE stmt;
    SELECT 1;
END $$
DELIMITER ;