package cs5200;

import java.sql.Date;

public class User {

	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Date dateOfBirth;
	
	// No argument constructor
	public User()
	{
		
	}
	
	
	
	// Constructor using all the fields in the Class 
	public User(String username, String password, String firstname,
			String lastname, String email, Date dateOfBirth) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
