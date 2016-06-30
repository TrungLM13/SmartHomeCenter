package BSM_Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.tools.internal.xjc.generator.bean.ImplStructureStrategy.Result;

import BSM_API.HiveAPI;
import BSM_Connection.*;
import BSM_Entity.*;

public class HiveProcedure {
	
	public void sp_ShowDeviceDetail(ConnectionHive conn){
		
		try {
			ResultSet m_ResultSet = conn.getM_Statement().executeQuery(HiveAPI.s_SelectTableDevice);
			ArrayList<IDevice> sensor_logs = new ArrayList<IDevice>();
			if (m_ResultSet != null) {
				while (m_ResultSet.next()) {
					IDevice log = new IDevice();
					log.setM_DeviceID(m_ResultSet.getString(1));
					log.setM_DeviceName(m_ResultSet.getString(2));
					log.setM_Location(m_ResultSet.getString(3));
					log.setM_Status(m_ResultSet.getString(4));
					
					sensor_logs.add(log);

				}
			}
			for (IDevice sensor_Logs2 : sensor_logs) {
				System.out.println(sensor_Logs2.getM_DeviceName() + "     " + sensor_Logs2.getM_DeviceID());
			}
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sp_CreateDataBase(ConnectionHive conn){
		
		try {
			conn.getM_Statement().execute(HiveAPI.s_CreateDataBase);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not create database");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public void sp_UseDataBase(ConnectionHive conn){
		
		try {
			conn.getM_Statement().execute(HiveAPI.s_UseDataBase);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not use database. DataBase is exits");
			e.printStackTrace();
		}
	}
	
	public void sp_CreateTableSensorLog(ConnectionHive conn){
		
		try {
			conn.getM_Statement().execute(HiveAPI.s_CreateSensorLogTable);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not create sensor log table. Table is exits or faild");
			e.printStackTrace();
		}
	}

	public void sp_LoadDataSensorLog(ConnectionHive conn){
		try {
			conn.getM_Statement().execute(HiveAPI.s_LoadDataSensoLogLocalInPath);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not load data to table");
			e.printStackTrace();
		}
	}

	public void sp_CreateTableDeviceDetail(ConnectionHive conn){
		
		try {
			conn.getM_Statement().execute(HiveAPI.s_CreateDeviceTable);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not create table: " + ITableName.s_Device  + " Table is exits or faild");
			e.printStackTrace();
		}
	}
	
	public void sp_LoadDataDeviceDetail(ConnectionHive conn){
		try {
			conn.getM_Statement().execute(HiveAPI.s_LoadDataDeviceDetailLocalInPath);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not load data to table: " + ITableName.s_Device);
			e.printStackTrace();
		}
	}
	
	public void sp_CreateTablePowerConsumption(ConnectionHive conn){
		
		try {
			conn.getM_Statement().execute(HiveAPI.s_CreatePowerConsumtionTable);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not create table: " + ITableName.s_Power  + " Table is exits or faild");
			e.printStackTrace();
		}
	}
	
	public void sp_LoadDataPowerConsumption(ConnectionHive conn){
		try {
			conn.getM_Statement().execute(HiveAPI.s_LoadDataPowerConsumptionLocalInPath);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not load data to table: " + ITableName.s_Power);
			e.printStackTrace();
		}
	}
	
	public void sp_DropALL(ConnectionHive conn){
		try {
			conn.getM_Statement().execute(HiveAPI.s_DropLogTable);
			conn.getM_Statement().execute(HiveAPI.s_DropDeviceTable);
			conn.getM_Statement().execute(HiveAPI.s_DropPowerTable);
			conn.getM_Statement().execute(HiveAPI.s_DropDataBase);
			System.out.println("Drop done");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Can not drop table or database");
			e.printStackTrace();
		}
	}

}
