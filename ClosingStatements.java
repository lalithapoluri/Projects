package daoinfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class ClosingStatements {
	
	public void closeConnection(Object obj) throws SQLException{
		
		if(obj!=null){
			if(obj instanceof PreparedStatement){
			
			PreparedStatement stmt= (PreparedStatement)obj;
			stmt.close();
			
			}
			
			if(obj instanceof ResultSet){
				
				ResultSet rs= (ResultSet)obj;
				rs.close();
				
				}
			
			if(obj instanceof Connection){
				
				Connection con= (Connection)obj;
				con.close();
				
				}
		
		}
		
	}
	
	
	

}
