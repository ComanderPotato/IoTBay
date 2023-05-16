package iotbay.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order implements Serializable {
    private int orderID;
    private int userAccountID;
    private int addressID;
    private int paymentID;
    private double orderTotal;
    private LocalDateTime orderDate;
    private String orderStatus;
    private ArrayList<OrderLineItem> orderLineItems;

    public Order() {

    }

    public Order(double orderTotal, LocalDateTime orderDate, String orderStatus) {
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Order(
            int orderID,
            int userAccountID,
            int addressID,
            int paymentID,
            double orderTotal,
            LocalDateTime orderDate,
            String orderStatus
    ) {
        this.orderID = orderID;
        this.userAccountID = userAccountID;
        this.addressID = addressID;
        this.paymentID = paymentID;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
    public Order(
            int orderID,
            int userAccountID,
            int addressID,
            int paymentID,
            double orderTotal,
            LocalDateTime orderDate,
            String orderStatus,
            ArrayList<OrderLineItem> orderLineItems
            ) {
        this.orderID = orderID;
        this.userAccountID = userAccountID;
        this.addressID = addressID;
        this.paymentID = paymentID;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderLineItems = orderLineItems;

    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public int getUserAccountID() {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID) {
        this.userAccountID = userAccountID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public ArrayList<OrderLineItem> getOrderLineItem() {
        return orderLineItems;
    }
    public void setOrderLineItem(ArrayList<OrderLineItem> orderLineItem) {
        this.orderLineItems = orderLineItems;
    }
}
