package de.com.episerver.model;

public class Autors {
	
	private String email;
	private String firstName;
	private String surname;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	 
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString(){
		return this.email + " " + this.firstName + " " + this.surname; 
	}
	
	

}
