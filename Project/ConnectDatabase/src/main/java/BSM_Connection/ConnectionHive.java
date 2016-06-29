package BSM_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionHive extends BSM_Connection.ConnectionBase {
	
	public  static 	String 		s_DriverName 		= "org.apache.hive.jdbc.HiveDriver";
	private static 	String 		s_ConnectionPort 	= "jdbc:hive2://192.168.204.129:10000";
	private static 	String 		s_TableName 		= "SM_DeviceDetail";
	
	private 		Connection 	m_Con;
	private 		Statement 	m_Statement			= null;
	
	public void CreateConnection() {
    	try {
			Class.forName(s_DriverName);
			
			m_Con = DriverManager.getConnection(s_ConnectionPort);
			
			setM_Statement(m_Con.createStatement());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Faild to establish connection");
			System.exit(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public	void	CloseConnection(){
		
	}

	public Statement getM_Statement() {
		return m_Statement;
	}

	public void setM_Statement(Statement m_Statement) {
		this.m_Statement = m_Statement;
	}

	public static String getS_ConnectionPort() {
		return s_ConnectionPort;
	}

	public static void setS_ConnectionPort(String s_ConnectionPort) {
		ConnectionHive.s_ConnectionPort = s_ConnectionPort;
	}

	public static String getS_TableName() {
		return s_TableName;
	}

	public static void setS_TableName(String s_TableName) {
		ConnectionHive.s_TableName = s_TableName;
	}

	private Connection getM_Con() {
		return m_Con;
	}

	private void setM_Con(Connection m_Con) {
		this.m_Con = m_Con;
	}
}
