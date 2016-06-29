CREATE TABLE IF NOT EXISTS SM_SensorLog ( messageID string, deviceID string, roomID string, power int, datePow string, duration int, deviceType string, deviceStatus string, additionalInfor string)
COMMENT 'Power CSC'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LINES TERMINATED BY '\n';
LOAD  DATA LOCAL INPATH  '/user/hadoop/TempData.txt' INTO TABLE SM_SensorLog;

SELECT* FROM SM_SensorLog;


