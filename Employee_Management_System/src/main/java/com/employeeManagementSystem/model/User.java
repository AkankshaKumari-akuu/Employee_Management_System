package com.employeeManagementSystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class User {
	
	@Id
	String userId;
	
	String password;
	
	String firstName;
	
	String lastName;
	
	String email;
	
	String address;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id")
    private Employee employee;
	
	
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
	public User(String userId, String password, String firstName, String lastName, String email, String address,
			Employee employee) {
		super();
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.employee = employee;
	}
	
}
