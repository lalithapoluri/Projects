package daoinfo;

public interface Dbconstants {
	
	public static String VALIDATEUSER="select email from user where email = ? and password = ?";
	
	
	public static String STOREUSER="insert into user(email,password,name,team,owns_vehicle,gender,can_drive,number) values (?,?,?,?,?,?,?,?) ";
	public static String STOREVEHICLE="insert into vehicle(email,vehicle_type,seats,vehicle_number,vehicle_color,vehicle_company) values (?,?,?,?,?,?) ";
	
	public static String STORETRIP="insert into trip(id,trip_name,trip_description,when,venue,time,email,status,invitedlist) values (?,?,?,?,?,?,?,?,?) ";
	public static String SHOWTEAMS="select team from user";//GETUSERS
	
	public static String SHOWTRIPS="select * from trip";
}
