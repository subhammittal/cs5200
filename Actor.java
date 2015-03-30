package cs5200;

import java.sql.Date;

public class Actor {

// id should be int as it is easy to implement uniqueness using int numbers
	private int id;
	private String firstname;
	private String lastname;
	private Date dateOfBirth;
	
	public Actor(){}

	public Actor(int id, String firstname, String lastname, Date dateOfBirth) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateOfBirth = dateOfBirth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	
}
