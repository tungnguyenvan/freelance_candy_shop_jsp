package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDatabase {
	private static final String DATABASENAME = "bakery";
	private static final String USERNAME = "DESTTOP-LHOVSEQ\\Nguyen Van Tung";
	private static final String PASSWORD = "";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName="+DATABASENAME+";integratedSecurity=true";
	
	private static java.sql.Connection instance;
	
	public static java.sql.Connection getInstance(){
		if (instance == null) instance = getConnect(DB_URL, USERNAME, PASSWORD);
		return instance;
	}
	
	private static Connection getConnect(String dbURL, String userName, String password){
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = (java.sql.Connection) DriverManager.getConnection(dbURL, userName, password);
			System.out.println("connect successfully!");
		} catch (SQLException e) {
			System.out.println("connect failure! : " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("connect failure! : " + e.getLocalizedMessage());
			e.printStackTrace();
		}
		return conn;
	}
	
	public static boolean excuteSQL(String sql) throws Exception {
		Connection connection = getInstance();
		Statement Statement = connection.createStatement();
		boolean result = Statement.execute(sql);
		return result;
	}
	
	public static ResultSet selectData(String sql) throws Exception{
		Connection connection = getInstance();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		return rs;
	}
}
