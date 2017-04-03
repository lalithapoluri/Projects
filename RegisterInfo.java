package mytravelarchitecture;



public class RegisterInfo {
	
	private String email,name,password,hasvehicle,candrive,team,gender;
	private Integer seats;
	private String number;
	
	private String vehicleType,vehicleNumber,vehicleColour,vehicleCompany;
	
	private String tripid,tripname,tripdesc,venue,time,tripstatus,userstatus;
	
	private String when;
	
	private String invitedlist;
	



	




	public String getInvitedlist() {
		return invitedlist;
	}





	public void setInvitedlist(String invitedlist) {
		this.invitedlist = invitedlist;
	}





	public String getWhen() {
		return when;
	}





	public void setWhen(String when) {
		this.when = when;
	}





	/*@Override
	public String toString() {
		return "RegisterInfo [email=" + email + ", name=" + name + "]";
	}
*/
	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getHasvehicle() {
		return hasvehicle;
	}





	public void setHasvehicle(String hasvehicle) {
		this.hasvehicle = hasvehicle;
	}





	public String getCandrive() {
		return candrive;
	}





	public void setCandrive(String candrive) {
		this.candrive = candrive;
	}





	public String getTeam() {
		return team;
	}





	public void setTeam(String team) {
		this.team = team;
	}





	public String getGender() {
		return gender;
	}





	public void setGender(String gender) {
		this.gender = gender;
	}





	public Integer getSeats() {
		return seats;
	}





	public void setSeats(Integer seats) {
		this.seats = seats;
	}





	public String getNumber() {
		return number;
	}





	public void setNumber(String number) {
		this.number = number;
	}





	public String getVehicleType() {
		return vehicleType;
	}





	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}





	public String getVehicleNumber() {
		return vehicleNumber;
	}





	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}





	public String getVehicleColour() {
		return vehicleColour;
	}





	public void setVehicleColour(String vehicleColour) {
		this.vehicleColour = vehicleColour;
	}





	public String getVehicleCompany() {
		return vehicleCompany;
	}





	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}





	public String getTripid() {
		return tripid;
	}





	public void setTripid(String tripid) {
		this.tripid = tripid;
	}





	public String getTripname() {
		return tripname;
	}





	public void setTripname(String tripname) {
		this.tripname = tripname;
	}





	public String getTripdesc() {
		return tripdesc;
	}





	public void setTripdesc(String tripdesc) {
		this.tripdesc = tripdesc;
	}





	public String getVenue() {
		return venue;
	}





	public void setVenue(String venue) {
		this.venue = venue;
	}





	public String getTime() {
		return time;
	}





	public void setTime(String time) {
		this.time = time;
	}





	public String getTripstatus() {
		return tripstatus;
	}





	public void setTripstatus(String tripstatus) {
		this.tripstatus = tripstatus;
	}





	public String getUserstatus() {
		return userstatus;
	}





	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((candrive == null) ? 0 : candrive.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((hasvehicle == null) ? 0 : hasvehicle.hashCode());
		result = prime * result
				+ ((invitedlist == null) ? 0 : invitedlist.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result
				+ ((tripdesc == null) ? 0 : tripdesc.hashCode());
		result = prime * result + ((tripid == null) ? 0 : tripid.hashCode());
		result = prime * result
				+ ((tripname == null) ? 0 : tripname.hashCode());
		result = prime * result
				+ ((tripstatus == null) ? 0 : tripstatus.hashCode());
		result = prime * result
				+ ((userstatus == null) ? 0 : userstatus.hashCode());
		result = prime * result
				+ ((vehicleColour == null) ? 0 : vehicleColour.hashCode());
		result = prime * result
				+ ((vehicleCompany == null) ? 0 : vehicleCompany.hashCode());
		result = prime * result
				+ ((vehicleNumber == null) ? 0 : vehicleNumber.hashCode());
		result = prime * result
				+ ((vehicleType == null) ? 0 : vehicleType.hashCode());
		result = prime * result + ((venue == null) ? 0 : venue.hashCode());
		result = prime * result + ((when == null) ? 0 : when.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterInfo other = (RegisterInfo) obj;
		if (candrive == null) {
			if (other.candrive != null)
				return false;
		} else if (!candrive.equals(other.candrive))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (hasvehicle == null) {
			if (other.hasvehicle != null)
				return false;
		} else if (!hasvehicle.equals(other.hasvehicle))
			return false;
		if (invitedlist == null) {
			if (other.invitedlist != null)
				return false;
		} else if (!invitedlist.equals(other.invitedlist))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (tripdesc == null) {
			if (other.tripdesc != null)
				return false;
		} else if (!tripdesc.equals(other.tripdesc))
			return false;
		if (tripid == null) {
			if (other.tripid != null)
				return false;
		} else if (!tripid.equals(other.tripid))
			return false;
		if (tripname == null) {
			if (other.tripname != null)
				return false;
		} else if (!tripname.equals(other.tripname))
			return false;
		if (tripstatus == null) {
			if (other.tripstatus != null)
				return false;
		} else if (!tripstatus.equals(other.tripstatus))
			return false;
		if (userstatus == null) {
			if (other.userstatus != null)
				return false;
		} else if (!userstatus.equals(other.userstatus))
			return false;
		if (vehicleColour == null) {
			if (other.vehicleColour != null)
				return false;
		} else if (!vehicleColour.equals(other.vehicleColour))
			return false;
		if (vehicleCompany == null) {
			if (other.vehicleCompany != null)
				return false;
		} else if (!vehicleCompany.equals(other.vehicleCompany))
			return false;
		if (vehicleNumber == null) {
			if (other.vehicleNumber != null)
				return false;
		} else if (!vehicleNumber.equals(other.vehicleNumber))
			return false;
		if (vehicleType == null) {
			if (other.vehicleType != null)
				return false;
		} else if (!vehicleType.equals(other.vehicleType))
			return false;
		if (venue == null) {
			if (other.venue != null)
				return false;
		} else if (!venue.equals(other.venue))
			return false;
		if (when == null) {
			if (other.when != null)
				return false;
		} else if (!when.equals(other.when))
			return false;
		return true;
	}





	public RegisterInfo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	



	public RegisterInfo(String email, String name, String password,
			String hasvehicle, String candrive, String team, String gender,
			Integer seats, String number, String vehicleType,
			String vehicleNumber, String vehicleColour, String vehicleCompany) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.hasvehicle = hasvehicle;
		this.candrive = candrive;
		this.team = team;
		this.gender = gender;
		this.seats = seats;
		this.number = number;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleColour = vehicleColour;
		this.vehicleCompany = vehicleCompany;
	}



	public RegisterInfo(String email, String name, String password,
			String hasvehicle, String candrive, String team, String gender,
			String number) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.hasvehicle = hasvehicle;
		this.candrive = candrive;
		this.team = team;
		this.gender = gender;
		this.number = number;
	}



	public RegisterInfo(String email, String hasvehicle, String vehicleType,
			Integer seats, String vehicleNumber, String vehicleColour,
			String vehicleCompany) {
		super();
		this.email = email;
		this.hasvehicle = hasvehicle;
		this.vehicleType = vehicleType;
		this.seats = seats;
		this.vehicleNumber = vehicleNumber;
		this.vehicleColour = vehicleColour;
		this.vehicleCompany = vehicleCompany;
	}





	public RegisterInfo(String tripid, String tripname,
			String tripdesc, String venue, String time, String tripstatus,
			String when,String invitedlist,String email) {
		super();
	
		this.tripid = tripid;
		this.tripname = tripname;
		this.tripdesc = tripdesc;
		this.venue = venue;
		this.time = time;
		this.tripstatus = tripstatus;
		this.when = when;
		this.email=email;
		this.invitedlist=invitedlist;
	}
	
	public RegisterInfo(String tripid, String tripname,
			String tripdesc, String venue, String time, String tripstatus,
			String when,String invitedlist,String email,String userstatus) {
		super();
	
		this.tripid = tripid;
		this.tripname = tripname;
		this.tripdesc = tripdesc;
		this.venue = venue;
		this.time = time;
		this.tripstatus = tripstatus;
		this.when = when;
		this.email=email;
		this.invitedlist=invitedlist;
		this.userstatus=userstatus;
	}

	

	




	public RegisterInfo(String email, String name, String number,
			String vehicleType, String vehicleNumber, String vehicleColour,
			String vehicleCompany) {
		super();
		this.email = email;
		this.name = name;
		this.number = number;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleColour = vehicleColour;
		this.vehicleCompany = vehicleCompany;
	}





	public RegisterInfo(String email, String name, Integer seats,
			String number, String vehicleType, String vehicleNumber,
			String vehicleColour, String vehicleCompany) {
		super();
		this.email = email;
		this.name = name;
		this.seats = seats;
		this.number = number;
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
		this.vehicleColour = vehicleColour;
		this.vehicleCompany = vehicleCompany;
	}





	public RegisterInfo(String email, String name, String candrive,
			String gender, String number) {
		super();
		this.email = email;
		this.name = name;
		this.candrive = candrive;
		this.gender = gender;
		this.number = number;
	}





	public RegisterInfo(String team) {
		super();
		this.team=team;
	}



}
