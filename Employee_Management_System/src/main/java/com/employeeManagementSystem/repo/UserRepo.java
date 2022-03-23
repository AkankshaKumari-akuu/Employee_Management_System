package com.employeeManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeManagementSystem.model.User;

public interface UserRepo extends JpaRepository<User,User>{

}