package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
 static Connection con;
 public static Connection createConnection()
 {
	 try
	 {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		String user="root";
		String pass="root"; //mysql username and password
		String url="jdbc:mysql://localhost:3306/student?autoRecoonect=true&useSSL=false";
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("connection established....");
		
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	 
	return con;
	 
 }
 
}
