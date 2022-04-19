package com.empolyee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {
	static String url = "jdbc:postgresql://localhost:5432/bank";
	static String userName="postgres";
	static String pass="Vikrant@2878";
	public static  Connection  createDbConnection(){
		
	Connection con=null;
	try {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection(url,userName,pass);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}
	

}
