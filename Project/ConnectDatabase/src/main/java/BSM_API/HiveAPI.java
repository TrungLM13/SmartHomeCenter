package BSM_API;

import BSM_Entity.*;
	
public class HiveAPI {
	
	public 	static	String 	s_CreateDataBase 					= 	"CREATE DATABASE IF NOT EXISTS " 		+ ITableName.s_DataBaseName;
	public 	static	String	s_UseDataBase						= 	"USE " 					+ ITableName.s_DataBaseName;
	public 	static	String	s_DropDataBase						= 	"DROP DATABASE "		+ ITableName.s_DataBaseName;
	
	public	static	String	s_CreateSensorLogTable				=	"CREATE TABLE IF NOT EXISTS " + ITableName.s_SensorLog 
																	+" ( messageID String, deviceID String, roomID String, power int, "
																	+ " datePow timestamp, duration int, deviceType String, deviceStatus String, additionalInfor String )"
																	+" COMMENT 'Data of Server MQTT'"
																	+" ROW FORMAT DELIMITED"
																	+" FIELDS TERMINATED BY ','"
																	+" LINES TERMINATED BY '\n'"
																	+" STORED AS TEXTFILE";
	
	public	static	String	s_CreateDeviceTable	=	"CREATE TABLE IF NOT EXISTS " +ITableName.s_Device
													+ " ( deviceID String, deviceName String, deviceLocation String, deviceStatus int )"
													+" COMMENT 'Device detail'"
											        +" ROW FORMAT DELIMITED"
											        +" FIELDS TERMINATED BY '\t'"
											        +" LINES TERMINATED BY '\n'"
											        +" STORED AS TEXTFILE";
	public	static	String	s_CreatePowerConsumtionTable = 
													"CREATE TABLE IF NOT EXISTS " +ITableName.s_Power 
													+ " ( deviceID String, datePow timestamp, timeConsumtion int, powerConsumtion int )"
													+" COMMENT 'Power Consumtion'"
											        +" ROW FORMAT DELIMITED"
											        +" FIELDS TERMINATED BY '\t'"
											        +" LINES TERMINATED BY '\n'"
											        +" STORED AS TEXTFILE";
	
	public	static	String	s_LoadDataSensoLogLocalInPath 			= "LOAD  DATA LOCAL INPATH  '/home/hduser2/ProjectBigData/TempData.txt' INTO TABLE " + ITableName.s_SensorLog;
	public	static	String	s_LoadDataDeviceDetailLocalInPath 		= "LOAD  DATA LOCAL INPATH  '/home/hduser2/ProjectBigData/TempDataDeviceDetail.txt' INTO TABLE " + ITableName.s_Device;
	public	static	String	s_LoadDataPowerConsumptionLocalInPath 	= "LOAD  DATA LOCAL INPATH  '/home/hduser2/ProjectBigData/TempDataPower.txt' INTO TABLE " + ITableName.s_Power;

	public	static	String 	s_SelectTableDevice				 	= 	"SELECT * FROM " 		+ ITableName.s_Device;

}
