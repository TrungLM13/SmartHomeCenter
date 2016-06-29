package com.hive.learn.ConnectDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class Sensor_Logs {
	public  String sensorname ;
	public  String time ;
	public  String value ;
	public  String user ;
}

/**
 * Hello world!
 *
 */


public class App {
	
	private Connection m_Con = null;
	private Statement m_Statement = null;
	
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        App test = new App();
        test.CreateConnection();
        test.ShowTable();
        
    }
    
    public void ShowTable() {
    	try {
			ResultSet m_ResultSet = m_Statement.executeQuery(IDefine.s_SelectAll);
			ArrayList<Sensor_Logs> sensor_logs = new ArrayList<Sensor_Logs>();
			if (m_ResultSet != null) {
				while (m_ResultSet.next()) {
					Sensor_Logs log = new Sensor_Logs();
					log.sensorname = m_ResultSet.getString(1);
					log.time = m_ResultSet.getString(2);
					log.value = m_ResultSet.getString(3);
					log.user = m_ResultSet.getString(4);
					sensor_logs.add(log);

				}
			}
			for (Sensor_Logs sensor_Logs2 : sensor_logs) {
				System.out.println(sensor_Logs2.sensorname);
			}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void CreateConnection() {
    	try {
			Class.forName(IDefine.s_DriverName);
			
			m_Con = DriverManager.getConnection(IDefine.s_ConnectionQuery);
			
			m_Statement = m_Con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
}
