package com.employeeManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="\"user\"")
public class User {
    @Id
    String userid;
    String first;
    String last;
    String email;
    Long phone;
    String password;
    String address;
    
    

 

    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }

 

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

 

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

 

}