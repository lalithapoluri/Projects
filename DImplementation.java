package daoinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;












import planTrip.LayoutBean;
import mytravelarchitecture.*;


public class DImplementation implements DInterface {
	
	
	@Override
	public boolean validateuser(RegisterInfo info) throws IllegalArgumentException, SQLException {
		
		
		System.out.println(" Entered DB function");
		Connection con = null;
		boolean passwordValid = false;
		con = DbUtilTravel.getCon();
		
		System.out.println("Connection got");
		
		/*String cmd="select email from user where email = ? and password = ?";*/
		try {
			PreparedStatement stmt = con.prepareStatement(Dbconstants.VALIDATEUSER);
			stmt.setString(1, info.getEmail());
			stmt.setString(2, info.getPassword());
			ResultSet rs = stmt.executeQuery();
			// check rs is null or not
			if(rs!=null){
				
				if(rs.next()){
					passwordValid = true;
					
				}
				
			}
			
				
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO Auto-generated catch block
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		return passwordValid;
		
	}

	@Override
	public void storeuserdetails(RegisterInfo info) throws SQLException,
			IllegalArgumentException {
		
		System.out.println("entered store details in DI");
		
		Connection con = null;
		con = DbUtilTravel.getCon();
		
		System.out.println("Connection got in store user details");
		
		/*String cmd="insert into user(email,password,name,team,owns_vehicle,gender,can_drive,number) values (?,?,?,?,?,?,?,?) ";
		String cmd1="insert into vehicle(email,vehicle_type,seats,vehicle_number,vehicle_color,vehicle_company) values (?,?,?,?,?,?) ";*/
		
		try {
			
			PreparedStatement stmt = con.prepareStatement(Dbconstants.STOREUSER);

			System.out.println(" After Command execution");
		
			stmt.setString(1, info.getEmail());
			stmt.setString(2, info.getPassword());
			stmt.setString(3, info.getName());
			stmt.setString(4, info.getTeam());
			stmt.setString(5, info.getHasvehicle());
			stmt.setString(6, info.getGender());
			stmt.setString(7, info.getCandrive());
			stmt.setString(8, info.getNumber());
			
			stmt.executeUpdate();
			
			stmt.close();
			
			System.out.println("after command-1");
			
			if(info.getHasvehicle().equals("Y")){
				
				System.out.println("came inside if");
				
				try {
					PreparedStatement stmt1 = con.prepareStatement(Dbconstants.STOREVEHICLE);
					
					stmt1.setString(1, info.getEmail());
					stmt1.setString(2, info.getVehicleType());
					stmt1.setInt(3, info.getSeats());
					stmt1.setString(4, info.getVehicleNumber());
					stmt1.setString(5, info.getVehicleColour());
					stmt1.setString(6, info.getVehicleCompany());
					
					System.out.println("after command-2");
					
					stmt1.executeUpdate();
					stmt1.close();
				} 
				
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		// TODO Auto-generated catch block
		try {
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("learn to die secretly");
		}
	}
	}
	
	
	

	@Override
	public List<RegisterInfo> showDetailsToUser()
			throws IllegalArgumentException, SQLException {
		
	/*public void showDetailsToUser()
			throws IllegalArgumentException {*/
		Connection con = null;
		List<RegisterInfo> l = null;
		
		con = DbUtilTravel.getCon();
		String cmd="select fname,approve,team from login";

		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			
			
			ResultSet rs = stmt.executeQuery();
			//System.out.println(rs);
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				/*String fname =rs.getString("fname");
				boolean approve=rs.getBoolean("approve");
				
				String team =rs.getString("team");*/
				
				
				//RegisterInfo r = new RegisterInfo(fname,team, approve);
			
				//l.add(r);
				//System.out.println(l);
				
			}
			
			
			
			//System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO Auto-generated catch block
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		return l;
		
		
	
	}

	@Override
	public void storetripdetails(RegisterInfo info) throws SQLException,
			IllegalArgumentException {
		
		System.out.println("entered store trip details in DI");
		
		Connection con = null;
		con = DbUtilTravel.getCon();
		
		System.out.println("Connection got in store user details");
		
		/*String cmd="insert into trip(id,trip_name,trip_description,when,venue,time,email,status,invitedlist) values (?,?,?,?,?,?,?,?,?) ";*/
		
		try {
			
			
			System.out.println("came to try");
			
			PreparedStatement stmt = con.prepareStatement(Dbconstants.STORETRIP);
			
			System.out.println(" After Command execution");
		
			stmt.setString(1, info.getTripid());
			stmt.setString(2, info.getTripname());
			stmt.setString(3, info.getTripdesc());
		
			stmt.setString(4,info.getWhen());
			stmt.setString(5, info.getVenue());
			stmt.setString(6, info.getTime());
			stmt.setString(7, info.getEmail() );
			stmt.setString(8, info.getTripstatus());
			stmt.setString(9, info.getInvitedlist());
			
			stmt.executeUpdate();
			
			stmt.close();
			
			System.out.println("after command-1");
			
			
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		// TODO Auto-generated catch block
		try {
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("learn to die secretly");
		}
	}
		
		
	}

	/** (non-Javadoc)
	 * @see daoinfo.DInterface#showTeamsToUser()
	 * 
	 */
	@Override
	public List<RegisterInfo> showTeamsToUser() throws IllegalArgumentException, SQLException {
	
		
		Connection con = null;
		List<RegisterInfo> l = null;
		System.out.println("inside show teams to user");
		con = DbUtilTravel.getCon();
		

		try {
			PreparedStatement stmt = con.prepareStatement(Dbconstants.SHOWTEAMS);
			System.out.println("entered try");
			
			ResultSet rs = stmt.executeQuery();
			//System.out.println(rs);
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				String team =rs.getString("team");
				RegisterInfo r = new RegisterInfo(team);
			
				l.add(r);
				
			}
			
			
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		System.out.println(l);
		return l;
	
	}

	@Override
	public List<RegisterInfo> showTripsToUser(String team,String email2) throws IllegalArgumentException, SQLException{
		Connection con = null;
		List<RegisterInfo> l = null;
		
		con = DbUtilTravel.getCon();
		String cmd="select t2.id,t2.trip_name,t2.trip_description,t2.when,t2.venue,t2.time,t2.email,t2.status,t2.invitedlist  "
				+ "from (select user_trip.id from user_trip where email= ? ) t1 right join "
				+ "(select trip.id,trip.trip_name,trip.trip_description,trip.when,trip.venue,trip.time,trip.email,trip.status,"
				+ "trip.invitedlist from trip inner join teamsinvitedlist on trip.id=teamsinvitedlist.id where "
				+ "teaminvited = ?) t2 on t1.id=t2.id where t1.id is null;";
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(2, team);
			stmt.setString(1, email2);
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				String id =rs.getString("id");
				String tripname =rs.getString("trip_name");
				String tripdesc =rs.getString("trip_description");
				String when =rs.getString("when");
				String venue =rs.getString("venue");
				String time =rs.getString("time");
				String email =rs.getString("email");
				String status =rs.getString("status");
				String invitedlist =rs.getString("invitedlist");
				
				RegisterInfo r = new RegisterInfo(id,tripname,tripdesc,venue,time,status,when,invitedlist,email);
				
				
			
				l.add(r);
				//System.out.println(l);
				
			}
			//System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		return l;
	}

	@Override
	public void storeteamsInvitedDetails(String tripid, String[] teams)
			throws SQLException, IllegalArgumentException {
		
			System.out.println("entered store teamsinvited details in DI");
		
		Connection con = null;
		con = DbUtilTravel.getCon();
		
		System.out.println("Connection got in store teamsinvited details");
		
		
		String cmd="insert into teamsinvitedlist(id,teaminvited) values (?,?) ";
		
		try {
			
			
			System.out.println("came to try");
			for(int i=0;i<teams.length;i++){
				
			PreparedStatement stmt = con.prepareStatement(cmd);
			
			System.out.println(" After Command execution");
			
			
				
			stmt.setString(1, tripid);
			stmt.setString(2, teams[i]);
			stmt.executeUpdate();
			
			stmt.close();
			}
			
			
			System.out.println("after command-1");
			
			
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} // catch close
		
		
		
		finally {
		// TODO Auto-generated catch block
		try {
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("learn to die secretly");
		}
	}// end of finally
		
		
	}// function close

	
	
	@Override
	public String getTeamfromEmail(String email) throws SQLException,
			IllegalArgumentException {
		
		
		System.out.println(" Entered DB function");
		Connection con = null;
		String team1=null;
		con = DbUtilTravel.getCon();
		
		System.out.println("Connection got");
		System.out.println(email);
		
		String cmd= "select team from user where email = ? " ;
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			System.out.println("came to prepared statement");
			stmt.setString(1, email);
			System.out.println("setting email value");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				
			team1 = rs.getString("team");
			
			}
			
			System.out.println(team1);
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				con.close();
			} catch (Exception e) {
				
				System.out.println("learn to die secretly");
			}
		}//end of finally
		
		return team1;
	}

	
	
	
	
	
	@Override
	public void storeUserStatus(String email, String tripid,String userstatus)
			throws SQLException, IllegalArgumentException {
	
		System.out.println(" user status");
		Connection con = null;
	
		con = DbUtilTravel.getCon();
		
		System.out.println("Connection got");
		
		String cmd="select userstatus from user_trip where email= ? and id= ?";
		
		try{
			
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1, email);
			stmt.setString(2, tripid);
			System.out.println("selecting status");
			ResultSet rs = stmt.executeQuery();
			
			if(!rs.next()){
				
				String cmd1= "insert into user_trip(userstatus,id,email) values (?,?,?) ";
				try {
					PreparedStatement stmt1 = con.prepareStatement(cmd1);
					System.out.println("came to insert");
					stmt1.setString(1, userstatus);
					stmt1.setString(2, tripid);
					stmt1.setString(3, email);
					
					stmt1.executeUpdate();
					
					stmt1.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
				
			else
			{
					
				String cmd2= "UPDATE user_trip SET userstatus= ?, email= ?, id= ? where email = ? and id= ? ";
					
				try {
						PreparedStatement stmt2 = con.prepareStatement(cmd2);
						System.out.println("came to update");
						stmt2.setString(1, userstatus);
						stmt2.setString(3, tripid);
						stmt2.setString(2, email);
						stmt2.setString(4, email);
						stmt2.setString(5, tripid);
						
						stmt2.executeUpdate();
						
						stmt2.close();
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					} 
					
					
				}
			stmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			try {
				con.close();
			} catch (Exception e) {
				
				System.out.println("learn to die secretly");
			}
			}
		}//end of finally

	
	@Override
	public List<RegisterInfo> showTripsWithUserStatus(String team,String email1)
			throws IllegalArgumentException, SQLException {
		
		Connection con = null;
		List<RegisterInfo> l = null;
		
		con = DbUtilTravel.getCon();
		String cmd="select trip.id,trip_name,trip_description,when,venue,time,trip.email,trip.status,invitedlist,user_trip.userstatus "
				+ "from trip inner join teamsinvitedlist on trip.id=teamsinvitedlist.id inner join user_trip on trip.id=user_trip.id where teaminvited = ? and user_trip.email= ? ";
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1, team);
			stmt.setString(2, email1);
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				String id =rs.getString("id");
				String tripname =rs.getString("trip_name");
				String tripdesc =rs.getString("trip_description");
				String when =rs.getString("when");
				String venue =rs.getString("venue");
				String time =rs.getString("time");
				String email =rs.getString("email");
				String status =rs.getString("status");
				String invitedlist =rs.getString("invitedlist");
				String userstatus=rs.getString("userstatus");
				
				RegisterInfo r = new RegisterInfo(id,tripname,tripdesc,venue,time,status,when,invitedlist,email,userstatus);
				
				
			
				l.add(r);
				//System.out.println(l);
				
			}
			//System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		return l;
	}

	@Override
	public List<RegisterInfo> showTripsWhichHeCanPlan(String email1)
			throws IllegalArgumentException, SQLException {
		
		Connection con = null;
		List<RegisterInfo> l = null;
		
		con = DbUtilTravel.getCon();
		String cmd="select id,trip_name,trip_description,when,venue,time,trip.email,status,"
				+ "invitedlist from trip where email = ?";
				
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1,email1);
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				String id =rs.getString("id");
				String tripname =rs.getString("trip_name");
				String tripdesc =rs.getString("trip_description");
				String when =rs.getString("when");
				String venue =rs.getString("venue");
				String time =rs.getString("time");
				String email =rs.getString("email");
				String status =rs.getString("status");
				String invitedlist =rs.getString("invitedlist");
				
				
				RegisterInfo r = new RegisterInfo(id,tripname,tripdesc,venue,time,status,when,invitedlist,email);
				
				
			
				l.add(r);
				//System.out.println(l);
				
			}
			//System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		return l;
	}

	@Override
	public List<RegisterInfo> showRegisteredUsersForTripWithoutVehicle(String tripid)
			throws IllegalArgumentException, SQLException {
		Connection con = null;
		List<RegisterInfo> l = null;
		
		con = DbUtilTravel.getCon();
		String cmd="select user_trip.email,user.name,user.can_drive,user.number,user.gender from user inner join "
				+ "user_trip on user_trip.email=user.email where user_trip.id= ? and user_trip.userstatus= ? and user.owns_vehicle= ?  ";
				
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1,tripid);
			stmt.setString(2, "coming");
			stmt.setString(3, "N");
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				
				String email =rs.getString("email");
				String name =rs.getString("name");
				String candrive =rs.getString("can_drive");
				int number=rs.getInt("number");
				String number1=Integer.toString(number);
				String gender=rs.getString("gender");
				
				RegisterInfo r = new RegisterInfo(email, name, candrive, gender, number1);
				
				l.add(r);
				System.out.println(l);
				
			}
			System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		return l;
	}

	@Override
	public List<RegisterInfo> showRegisteredUsersForTripWithCar(
			String tripid) throws IllegalArgumentException, SQLException {
		Connection con = null;
		List<RegisterInfo> l = null;
		
		con = DbUtilTravel.getCon();
		String cmd="select user_trip.email,user.name,user.number,vehicle.vehicle_type,vehicle.seats,"
				+ "vehicle.vehicle_number,vehicle.vehicle_color,vehicle.vehicle_company"
				+ " from user inner join user_trip on user_trip.email=user.email inner join vehicle on "
				+ "user.email=vehicle.email where user_trip.id= ? and user_trip.userstatus= ? and"
				+ " user.owns_vehicle= ? and vehicle.vehicle_type= ? ";
				
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1,tripid);
			stmt.setString(2, "coming");
			stmt.setString(3, "Y");
			stmt.setString(4, "car");
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				
				String email =rs.getString("email");
				String name =rs.getString("name");
				int number=rs.getInt("number");
				String number1=Integer.toString(number);
				
				String vehicleNumber =rs.getString("vehicle_number");
				String vehicleColour =rs.getString("vehicle_color");
				String vehicleCompany =rs.getString("vehicle_company");
				String vehicleType =rs.getString("vehicle_type");
				Integer seats=rs.getInt("seats");
				
				RegisterInfo r = new RegisterInfo(email, name, seats, number1, vehicleType, vehicleNumber, vehicleColour, vehicleCompany);
				
				l.add(r);
				System.out.println(l);
				
			}
			System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		return l;
	}

	@Override
	public List<RegisterInfo> showRegisteredUsersForTripWithBike(
			String tripid) throws IllegalArgumentException, SQLException {
		Connection con = null;
		List<RegisterInfo> l = null;
		
		con = DbUtilTravel.getCon();
		String cmd="select user_trip.email,user.name,user.number,vehicle.vehicle_type,"
				+ "vehicle.vehicle_number,vehicle.vehicle_color,vehicle.vehicle_company"
				+ " from user inner join user_trip on user_trip.email=user.email inner join vehicle on "
				+ "user.email=vehicle.email where user_trip.id= ? and user_trip.userstatus= ? and"
				+ " user.owns_vehicle= ? and vehicle.vehicle_type= ? ";
				
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1,tripid);
			stmt.setString(2, "coming");
			stmt.setString(3, "Y");
			stmt.setString(4, "byke");
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<RegisterInfo>();
			
			while(rs.next()){

				
				String email =rs.getString("email");
				String name =rs.getString("name");
				int number=rs.getInt("number");
				String number1=Integer.toString(number);
				String vehicleNumber =rs.getString("vehicle_number");
				String vehicleColour =rs.getString("vehicle_color");
				String vehicleCompany =rs.getString("vehicle_company");
				String vehicleType =rs.getString("vehicle_type");
				
				
				RegisterInfo r = new RegisterInfo(email, name, number1, vehicleType, vehicleNumber, vehicleColour, vehicleCompany);
				l.add(r);
				System.out.println(l);
				
			}
			System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		return l;
	}
	
	
	
	

	@Override
	public void storeLayoutInfo(List<LayoutBean> x) throws IllegalArgumentException,
			SQLException {
		
		Connection con = null;
		con = DbUtilTravel.getCon();
		
		/*StringBuilder s=new StringBuilder();
		
		int len=x.size();
		
		for(int i=0;i<len;i++){
			
			
			s.append("\'"+x.get(i).getDriver()+"\'"+",");
			
		}
		int j=s.length();
		s.deleteCharAt(j-1);
		System.out.println(s);*/
		
		System.out.println("came to merge");
		
		
		String cmd="MERGE INTO layoutinfo KEY(name,ID,vehicle_number) VALUES(?,?,?)";
		
		try {
			
			for(int i=0;i<x.size();i++){
				
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1,x.get(i).getName());
			stmt.setString(2,x.get(i).getTripid());
			stmt.setString(3,x.get(i).getVehicleNumber());
			
			
			stmt.executeUpdate();
			
			stmt.close();
			}
			
			System.out.println("out of merge");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
		//System.out.println(l);
		}
	
	

	@Override
	public List<LayoutBean> fetchLayoutInfo(String tripId) throws IllegalArgumentException,
			SQLException {
		
		Connection con = null;
		List<LayoutBean> l=null;
		
		con = DbUtilTravel.getCon();
		String cmd="select * from layoutinfo where id= ?";
				
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			stmt.setString(1,tripId);
			
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<LayoutBean>();
			
			while(rs.next()){

				
				String vehicleNumber =rs.getString("vehicle_number");
				String tripid =rs.getString("id");
				String name =rs.getString("name");
				

				LayoutBean r = new LayoutBean(vehicleNumber, tripid, name);
				l.add(r);
				System.out.println(l);
				
			}
			System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
	
		return l;
	}

	@Override
	public List<LayoutBean> fetchLayoutMembers(List<String> distinctVehNum)
			throws IllegalArgumentException, SQLException {
		
		Connection con = null;
		List<LayoutBean> l=null;
		
		con = DbUtilTravel.getCon();
		String cmd="select * from layoutinfo where id= ?";
				
		
		try {
			PreparedStatement stmt = con.prepareStatement(cmd);
			//stmt.setString(1,tripId);
			
			ResultSet rs = stmt.executeQuery();
			
			l = new ArrayList<LayoutBean>();
			
			while(rs.next()){

				
				String vehicleNumber =rs.getString("vehicle_number");
				String tripid =rs.getString("id");
				String name =rs.getString("name");
				

				LayoutBean r = new LayoutBean(vehicleNumber, tripid, name);
				l.add(r);
				System.out.println(l);
				
			}
			System.out.println(l);
			
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con!=null){
				con.close();
			}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("learn to die secretly");
			}
		}
		
	
		return l;

	}

}




















