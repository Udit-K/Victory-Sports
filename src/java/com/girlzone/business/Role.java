/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlzone.business;

import java.io.Serializable;

/**
 *
 * @author jyoti
 */
public class Role implements Serializable {
    
    private String Role;

    public Role(String Role) {
        this.Role = Role;
    }
    
    public Role() {
    }


    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getRole() {
        return Role;
    }

    
}
