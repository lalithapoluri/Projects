package daoinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtilTravel {

	public static Connection getCon() throws IllegalArgumentException, SQLException {
		
		System.out.println("getcon of DBUtil");
		
		Connection con = null;
		String driverClass="org.h2.Driver";
		String url="jdbc:h2:~/test";
		String userid="sa";
		String password="";
		
		System.out.println(" after ");
		
		try {
			System.out.println("went to try-1");
			Class.forName(driverClass);
			System.out.println("went to try-2");
			con = DriverManager.getConnection(url, userid, password);
			
			System.out.println("went to try-3");
		} catch (ClassNotFoundException e) {
			
			throw new IllegalArgumentException("db not working");
		} catch (SQLException e) {
			
			throw new IllegalArgumentException("db not working gf");
		}
	
		return con;
	}
	
	/*public static void main(String[] args) throws IllegalArgumentException, SQLException {
		getCon();
		System.out.println("hello");
		
		
	}*/

}