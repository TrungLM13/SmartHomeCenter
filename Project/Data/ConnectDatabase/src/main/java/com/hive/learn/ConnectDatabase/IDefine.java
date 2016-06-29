package com.hive.learn.ConnectDatabase;

public class IDefine {
	public static String s_DriverName = "org.apache.hive.jdbc.HiveDriver";
	public static String s_ConnectionQuery = "jdbc:hive://192.168.178.128:10000";
	public static String s_TableName = "SM_DeviceDetail";

	public static String s_SelectAll = "SELECT * FROM " + s_TableName +" limit 100";
}
