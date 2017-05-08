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
public class Menu implements Serializable {
    
    private int MenuNumber;
    private String MenuItem;
    private String MenuType;
    private Double Price;

    public Menu(int MenuNumber, String MenuItem, String MenuType, Double Price) {
        this.MenuNumber = MenuNumber;
        this.MenuItem = MenuItem;
        this.MenuType = MenuType;
        this.Price = Price;
    }
    
    public Menu() {
        }

    public void setMenuNumber(int MenuNumber) {
        this.MenuNumber = MenuNumber;
    }

    public void setMenuItem(String MenuItem) {
        this.MenuItem = MenuItem;
    }

    public void setMenuType(String MenuType) {
        this.MenuType = MenuType;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public int getMenuNumber() {
        return MenuNumber;
    }

    public String getMenuItem() {
        return MenuItem;
    }

    public String getMenuType() {
        return MenuType;
    }

    public Double getPrice() {
        return Price;
    }

}
