package net.atm.user.model;

import java.time.LocalDate;

public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateCreated;
	
	public User(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateCreated = LocalDate.now();
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLatsName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "Id: " + this.id + "Name: " + this.firstName  + " " + this.lastName + "\n" + "Email: " + this.email + "\n" +  "Date created: " + this.dateCreated.toString() + "\n";
	}
}
