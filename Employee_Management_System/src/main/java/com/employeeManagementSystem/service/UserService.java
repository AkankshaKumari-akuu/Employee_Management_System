package com.employeeManagementSystem.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagementSystem.model.User;
import com.employeeManagementSystem.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo usempl;

	public void saveUser(User user) {
		usempl.save(user);
	}

	public ArrayList<User> getAllUser() {
		return (ArrayList<User>) usempl.findAll();
	}

}
