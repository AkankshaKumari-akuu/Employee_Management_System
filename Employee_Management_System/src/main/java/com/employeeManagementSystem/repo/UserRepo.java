package com.employeeManagementSystem.repo;

import org.springframework.data.repository.CrudRepository;

import com.employeeManagementSystem.model.User;

/*
 * Implementing the UserRepo Class to do  Database operation
 */

public interface UserRepo extends CrudRepository<User, String> {

}
