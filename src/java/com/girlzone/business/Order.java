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
public class Order implements Serializable {

    private String OrderId;
    private String username;
    private String OrderTime;
    private String ProcessingTime;
    private float amount;
    private String ResponseTime;
    private int MenuNumber;
    private String MenuItem;
    private int Quantity;
    private Double ProcessorNumber;
    private Double ServerNumber;
    private List<Menu> menuList;
    private Double total;
    private String orderStatus;

    public Order(String OrderId, String username, String OrderTime, String ProcessingTime, String ResponseTime, int MenuNumber, int Quantity, Double ProcessorNumber, Double ServerNumber, List<Menu> menuList, Double total) {
        this.OrderId = OrderId;
        this.username = username;
        this.OrderTime = OrderTime;
        this.ProcessingTime = ProcessingTime;
        this.ResponseTime = ResponseTime;
        this.MenuNumber = MenuNumber;
        this.Quantity = Quantity;
        this.ProcessorNumber = ProcessorNumber;
        this.ServerNumber = ServerNumber;
        this.menuList = menuList;
        this.total = total;
    }

    public String getOrderStatus() {
        return orderStatus;
    }public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public Order() {
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public void setOrderTime(String OrderTime) {
        this.OrderTime = OrderTime;
    }

    public void setProcessingTime(String ProcessingTime) {
        this.ProcessingTime = ProcessingTime;
    }

    public void setResponseTime(String ResponseTime) {
        this.ResponseTime = ResponseTime;
    }

    public void setMenuNumber(int MenuNumber) {
        this.MenuNumber = MenuNumber;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setProcessorNumber(Double ProcessorNumber) {
        this.ProcessorNumber = ProcessorNumber;
    }

    public void setServerNumber(Double ServerNumber) {
        this.ServerNumber = ServerNumber;
    }

    public String getOrderId() {
        return OrderId;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public String getProcessingTime() {
        return ProcessingTime;
    }

    public String getResponseTime() {
        return ResponseTime;
    }

    public int getMenuNumber() {
        return MenuNumber;
    }

    public int getQuantity() {
        return Quantity;
    }

    public Double getProcessorNumber() {
        return ProcessorNumber;
    }

    public Double getServerNumber() {
        return ServerNumber;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public String getMenuItem() {
        return MenuItem;
    }

    public void setMenuItem(String MenuItem) {
        this.MenuItem = MenuItem;
    }

    @Override
    public String toString() {
        return "Order{" + "username=" + username + ", OrderTime=" + OrderTime + ", ProcessingTime=" + ProcessingTime + ", ResponseTime=" + ResponseTime + ", MenuItem=" + MenuItem + ", Quantity=" + Quantity + ", total=" + total + '}';
    }
    
    
}
