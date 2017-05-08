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
public class Password implements Serializable{
    
    private String UserName;
    private String Password;
    private String Salt;

    public Password(String UserName, String Password, String Salt) {
        this.UserName = UserName;
        this.Password = Password;
        this.Salt = Salt;
    }
   

     public Password() {
        }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setSalt(String Salt) {
        this.Salt = Salt;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getSalt() {
        return Salt;
    }
   
    
}

