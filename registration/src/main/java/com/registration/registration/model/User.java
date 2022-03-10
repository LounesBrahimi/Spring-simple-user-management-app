package com.registration.registration.model;

import lombok.Data;

@Data
public class User {

    private Long id;

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String firstName;

    private String lastName;

    private String mail;

    private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password2) {
		this.password = password2;
		
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}