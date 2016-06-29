package com.hive.learn.GUI;

import java.util.Scanner;

import BSM_Entity.*;
import BSM_Logic.HiveProcedure;
import BSM_Connection.*;

public class App {
	
	public 	ConnectionHive 	hiveConnection;
	public	HiveProcedure	hiveProcedure;
	
	public	boolean m_run;
	
	public App(){
		hiveConnection 	= new ConnectionHive();
		hiveProcedure	= new HiveProcedure();
		m_run			= true;
	}
	
	public void Menu(){
		System.out.println("------------------------------------------------------");
		System.out.println("------------WELLCOM TO SMART HOME CENTER--------------");
		System.out.println("------------------------------------------------------");
		System.out.println("1 - Start DataBase");
		System.out.println("2 - Show log sensor");
		System.out.println("3 - Show device detail");
		System.out.println("4 - Show power consumption");
		System.out.println("5 - Running load data sensor process");
		System.out.println("9 - Show Menu");
		System.out.println("------------------------------------------------------");
		System.out.println("0 - Quit");
		System.out.println("--------------------THANK YOU-------------------------");
	}
	
	public void StartServer(){
		System.out.println("Start Service ....");
		this.hiveConnection.CreateConnection();
        System.out.println("Establish Connection");
        this.hiveProcedure.sp_CreateDataBase(this.hiveConnection);
        System.out.println("Sucsess create Database " +  ITableName.s_DataBaseName + "\n");
        this.hiveProcedure.sp_UseDataBase(this.hiveConnection);
        System.out.println("Using DataBase" + "\n");
        this.hiveProcedure.sp_CreateTableSensorLog(this.hiveConnection);
        this.hiveProcedure.sp_CreateTableDeviceDetail(this.hiveConnection);
        this.hiveProcedure.sp_CreateTablePowerConsumption(this.hiveConnection);
        System.out.println("Sucsess create table" + "\n" );
        this.hiveProcedure.sp_LoadDataSensorLog(this.hiveConnection);
        this.hiveProcedure.sp_LoadDataDeviceDetail(this.hiveConnection);
        this.hiveProcedure.sp_LoadDataPowerConsumption(this.hiveConnection);
        System.out.println("LOAD DATA ALL");
        System.out.println("DONE ALL");
	}
    @SuppressWarnings("resource")
	public static void main( String[] args ) {
    	
    	int c_input;
    	
    	Scanner scanner = new Scanner(System.in);
 	
        System.out.println( "Welcom to SmartHome Central!" );
        
        App center = new App();
        center.Menu();
        
        while(center.m_run){
        	c_input = scanner.nextInt();
        	switch (c_input) {
			case 0:
				System.out.println("Goodbye");
				break;
			case 1:
				center.StartServer();
				break;
			case 2:
				System.out.println("Show log sensor");
				break;
			case 3:
				System.out.println("Show device detail");
				break;
			case 4:
				System.out.println("Show powerconsumption");
				break;
			case 5:
				center.hiveProcedure.sp_LoadDataSensorLog(center.hiveConnection);
				System.out.println("Load data success");
				break;
			case 9:
				center.Menu();
				break;
			default:
				break;
			}
        	
        	
        }    
    }  
}
