package com.employeeManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	String userId;
	
	String password;
	
	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public User() {
		
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
