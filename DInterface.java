package daoinfo;

import java.sql.SQLException;
import java.util.List;

import planTrip.LayoutBean;
import mytravelarchitecture.*;


public interface DInterface {
	
	boolean validateuser(RegisterInfo info) throws IllegalArgumentException, SQLException;
	
	void storeuserdetails(RegisterInfo info) throws SQLException,IllegalArgumentException;
	
	
	
	List<RegisterInfo> showDetailsToUser() throws IllegalArgumentException, SQLException;
	
	List<RegisterInfo> showTeamsToUser() throws IllegalArgumentException, SQLException;
	
	List<RegisterInfo> showTripsToUser(String team,String email) throws IllegalArgumentException,SQLException;
	
	void storetripdetails(RegisterInfo info) throws SQLException,IllegalArgumentException;
	
	void storeteamsInvitedDetails(String tripid,String[] teams) throws SQLException,IllegalArgumentException;
	
	String getTeamfromEmail(String email) throws SQLException,IllegalArgumentException;
	
	void storeUserStatus(String email,String tripid,String userstatus) throws SQLException,IllegalArgumentException;
	
	List<RegisterInfo> showTripsWithUserStatus(String team,String email) throws IllegalArgumentException,SQLException;
	
	List<RegisterInfo> showTripsWhichHeCanPlan(String email) throws IllegalArgumentException,SQLException;
	
	List<RegisterInfo> showRegisteredUsersForTripWithCar(String tripid) throws IllegalArgumentException,SQLException;
	List<RegisterInfo> showRegisteredUsersForTripWithBike(String tripid) throws IllegalArgumentException,SQLException;
	List<RegisterInfo> showRegisteredUsersForTripWithoutVehicle(String tripid) throws IllegalArgumentException,SQLException;
	
	void storeLayoutInfo(List<LayoutBean> layoutinfo) throws IllegalArgumentException,SQLException;
	
	List<LayoutBean> fetchLayoutInfo(String tripid) throws IllegalArgumentException,SQLException;
	
	List<LayoutBean> fetchLayoutMembers(List<String> distinctVehNum ) throws IllegalArgumentException,SQLException;

}
