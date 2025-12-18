package org.yearup.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SalesOrder {
    private int orderId;
    private int userId;
    private String shippingAddress;
    private String city;
    private String state;
    private String zip;
    private BigDecimal shippingCost;
    private LocalDateTime orderDate;

    public SalesOrder() {
    }

    public SalesOrder(int orderId, int userId, String shippingAddress, String city, String state, String zip, BigDecimal shippingCost, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.shippingAddress = shippingAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.shippingCost = shippingCost;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
