/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlzone.business;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jyoti
 */
public class User implements Serializable{
    
    private String UserName;
    private String Email;
    private String FirstName;
    private String LastName;
    private String Password;
    private String Role;
    private String Address;
    private String City;
    private String State;
    private int Zipcode;
    private int PhoneNumber;
    
    public User() {
        }
    
    public User(String UserName, String Email, String FirstName, String LastName, String Password, String Role, String Address, String City, String State, int Zipcode, int PhoneNumber) {
        this.UserName = UserName;
        this.Email = Email;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
        this.Role = Role;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Zipcode = Zipcode;
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public int getZipcode() {
        return Zipcode;
    }

    public void setZipcode(int Zipcode) {
        this.Zipcode = Zipcode;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
  
  


    
    

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPassword() {
        return Password;
    }
    
    

    public String getRole() {
        return Role;
    }

   

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

 

    @Override
    public String toString() {
        return "User{" + "UserName=" + UserName + ", Email=" + Email + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Role=" + Role + '}';
    }
    
    
    
    
    
    
    
          
          
    
}

