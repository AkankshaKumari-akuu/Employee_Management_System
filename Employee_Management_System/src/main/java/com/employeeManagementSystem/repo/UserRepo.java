package com.employeeManagementSystem.repo;

import org.springframework.data.repository.CrudRepository;

import com.employeeManagementSystem.model.User;

public interface UserRepo extends CrudRepository<User, String> {

}
