package register;
import java.sql.SQLException;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import serviceinfo.*;

import mytravelarchitecture.*;


import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterClick extends ActionSupport implements ModelDriven,SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6334655814929745119L;
	private RegisterData x;
	private String newPwd;
	Map<String, Object> session;
	public String execute() throws SQLException{
		
		// addActionError(getText("error.login"));
		
		System.out.println("entered register click");
		
		String pwd=x.getPassword();
		int sum=0;
		int j=0;
		
		for(int i=0;i<pwd.length();i++){
			
		char character = pwd.charAt(i); // This gives the character 'a'
			int ascii = (int) character; // ascii is now 97.
			sum=sum+ascii+j;
			j=j+1;
			
		}
		
		System.out.println(sum);
		 newPwd= Integer.toString(sum);
		
		RegisterInfo info_login= new RegisterInfo(x.getEmail(), x.getName(),newPwd, x.getHasvehicle(),
				x.getCandrive(), x.getTeam(), x.getGender(), x.getSeats(), x.getNumber(), x.getVehicleType(), 
				x.getVehicleNumber(), x.getVehicleColour(), x.getVehicleCompany());
		
		System.out.println(info_login);
	
		SInterface y=new SImplementation();
		String val= y.registerUser(info_login);
		
		System.out.println(val);
		
		 if (val.equals("ok")   ) {
			return "success";
	        } else {
	        	return "error";
	            //addActionError(getText("error.login")); 
	        }
		
		
	}

	@Override
	public Object getModel() {
		
		x = new RegisterData();
		return x;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}

}
